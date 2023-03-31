import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Point{
		int row;
		int col;
		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[r + 2][c + 2];
		int totalCheese = 0;
		for (int i = 1; i <= r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= c; j++) {
				map[i][j] = st.nextToken().charAt(0);
				// 입력 받으며 개수 카운트
				if (map[i][j] == '1') {
					totalCheese++;
				}
			}
		}
		
		if (totalCheese == 0) {
			System.out.println("0\n0");
			return;
		}
		
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		LinkedList<Point> outerAir = new LinkedList<>();
		boolean[][] visited = new boolean[r + 2][c + 2];
		// 외부 공기임이 보장된 테두리의 한 지점부터 탐색 시작
		visited[1][1] = true;
		// 이번 time에 탐색할 외부 공기
		outerAir.addLast(new Point(1, 1));
		// 현재 경과 시간
		int time = 0;
		// 이전 시간에 남은 치즈 개수
		int remain = totalCheese;
		while(!outerAir.isEmpty()) {
			// 시간 경과
			time++;
			// 남은 개수 저장
			remain = totalCheese;
			// 외부 공기와 접촉한 치즈 위치(탐색한 다음 시간에 외부 공기가 될 위치)
			LinkedList<Point> airsideCheese = new LinkedList<>();
			// 외부 공기로부터 탐색
			while(!outerAir.isEmpty()) {
				Point now = outerAir.pollFirst();
				for(int d = 0; d < 4; d++) {
					int nextRow = now.row + dr[d];
					int nextCol = now.col + dc[d];
					if (visited[nextRow][nextCol]) continue;
					visited[nextRow][nextCol] = true;
					// 탐색 지점이 외부 공기이면 외부와 이어진 공기이므로 '이번 시간'에 탐색해야하니 outerAir에 넣기
					if (map[nextRow][nextCol] == '0') {
						outerAir.addLast(new Point(nextRow, nextCol));
					}
					// 탐색 지점이 치즈이면 '다음 시간'에 외부 공기로 변하니 airsideCheese에 넣기
					else if(map[nextRow][nextCol] == '1') {
						airsideCheese.addLast(new Point(nextRow, nextCol));
						// 넣으면서 총 개수 줄이는데, 0개가 되면 시간과 바로 전 시간에 남은 개수 출력
						if (--totalCheese == 0) {
							System.out.println(time);
							System.out.println(remain);
							return;
						}
					}
				}
			}
			// 이번 시간의 다음 탐색지점(치즈가 외부공기로 변하는 지점)을 다음 외부공기로 등록
			outerAir = airsideCheese;
		}
		
	}
}
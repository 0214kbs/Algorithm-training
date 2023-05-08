import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];

		int[] B = new int[4]; // y, x, state, cnt
		int[] E = new int[3]; // y, x

		boolean flagB = false; // 좌측 상단 기둥 발견 여부
		boolean flagE = false; // 좌측 상단 도착지 발견 여부

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				char c = str.charAt(j);

				if (c == 'B') {
					if (!flagB) {
						B[0] = i;
						B[1] = j;
						flagB = true;
					} else {
						if (B[0] + 1 == i) B[2] = 1; // 수직
						else if (B[1] + 1 == j) B[2] = 0; // 수평
					}
				} else if (c == 'E') {
					if (!flagE) {
						E[0] = i;
						E[1] = j;
						flagE = true;
					} else {
						if (E[0] + 1 == i) E[2] = 1; // 수직
						else if (E[1] + 1 == j) E[2] = 0; // 수평
					}
				}
				if (c != '1') map[i][j] = 0;
				else map[i][j] = 1;
			}
		}

		int ans = 0;

		int[][][] visit = new int[N][N][2]; // 좌측 상단 좌표 + (수직,수평)상태 방문 여부
		Queue<int[]> q = new ArrayDeque<>();
		q.add(B);
		int sum = 0;
		while (!q.isEmpty()) {
			int[] t = q.poll();
			int y = t[0];
			int x = t[1];
			int s = t[2];
			int cnt = t[3];
			
			if(visit[y][x][s]==1) continue;
			
			visit[y][x][s]=1;
			
			if(y==E[0] && x == E[1] && s==E[2]) {
				ans=cnt;
				break;
			}
			
			// 상
			if (y > 0) {
				if (s == 1 && map[y - 1][x] != 1)
					q.add(new int[] { y - 1, x, s, cnt + 1 });
				else if (s == 0) {
					sum = 0;
					for (int i = 0; i < 3; i++) {
						sum += map[y - 1][x + i];
					}
					if (sum == 0)
						q.add(new int[] { y - 1, x, s, cnt + 1 });
				}
			}
			// 하
			if (s == 0 && y < N - 1) {
				sum = 0;
				for (int i = 0; i < 3; i++) {
					sum += map[y + 1][x + i];
				}
				if (sum == 0)
					q.add(new int[] { y + 1, x, s, cnt + 1 });
			} else if (s == 1 && y < N - 3 && map[y + 3][x] != 1) {
				q.add(new int[] { y + 1, x, s, cnt + 1 });
			}
			// 좌
			if (x > 0) {
				if(s==0 && map[y][x-1]!=1)
					q.add(new int[] { y, x - 1, s, cnt + 1 });
				else if (s == 1) {
					sum = 0;
					for (int i = 0; i < 3; i++) {
						sum += map[y + i][x - 1];
					}
					if (sum == 0)
						q.add(new int[] { y, x - 1, s, cnt + 1 });
				}
			}
			// 우
			if (s == 0 && x < N - 3 && map[y][x+3]!=1) {
				q.add(new int[] { y, x + 1, s, cnt + 1 });
			} else if (s == 1 && x < N - 1) {
				sum=0;
				for(int i=0; i<3; i++) {
					sum+=map[y+i][x+1];
				}
				if(sum==0) q.add(new int[] { y, x + 1, s, cnt + 1 });
			}
			// 회전(우측 상단 'B' 기준)
			if (s == 0 && y<N-1 && y>0) {
				
				sum = 0;
				for(int i=0; i<3; i++) sum+=map[y-1][x+i];
				for(int i=0; i<3; i++) sum+=map[y+1][x+i];
				if(sum==0) q.add(new int[] {y-1, x+1, 1, cnt+1});
				
			}else if(s==1 && x<N-1 && x>0) {
				
				sum=0;
				for(int i=0; i<3; i++) sum+=map[y+i][x-1];
				for(int i=0; i<3; i++) sum+=map[y+i][x+1];
				if(sum==0) q.add(new int[] {y+1, x-1, 0, cnt+1});
				
			}

		}
		System.out.println(ans);
	}
}

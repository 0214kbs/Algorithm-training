import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R,C,downR; // downR : 공기청정기 r좌표 (?-1,1) downR(?,1) 
	static int[][] board, copy;
	
	static class Pair{
		int r,c;

		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		board = new int[R][C];
		copy = new int[R][C];
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j]== -1) downR = i;
			}
		}
		
		for(int t=0;t<T;t++) {
			spread();
			copyToBoard();
			upCycle();
			downCycle();
			
		}
		int res = 0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(board[i][j]>0) res+=board[i][j];
			}
		}
		System.out.println(res);
	}
	
	static void spread() {
		// 확산 방향
		int[] dr = {-1,1,0,0}; // 상하좌우
		int[] dc = {0,0,-1,1};
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(board[i][j]==0) continue;
				
				int cnt = 0; // 상하좌우 이동 여부 
				int nr, nc;
				for(int d = 0;d<4;d++) { // 상하좌우 확산
					nr = dr[d]+i;
					nc = dc[d]+j;
					if(nr<0 || nr>=R || nc<0 || nc>=C || (nc==0 &&nr == downR)|| (nc==0 &&nr == downR-1)) continue;
					copy[nr][nc] += board[i][j]/5;
					cnt++;
				}
				copy[i][j] += board[i][j]-cnt*(board[i][j]/5);
			}
		}
	}
	static void copyToBoard() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				board[i][j] = copy[i][j];
			}
		}
//		copy = new int[R][C];
		// 시간 비교 
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				copy[i][j] = 0;
			}
		}
	}
	// 위쪽 순환 
	static void upCycle() {
		int upR = downR-1;
		// 좌-> 우 
		int tmp1 = board[upR][C-1];
		for(int j=C-2;j>0;j--) {
			board[upR][j+1] = board[upR][j];
		}
		board[upR][1] = 0;

		// 하 -> 상 
		int tmp2 = board[0][C-1];
		for(int i=0;i<upR;i++) {
			board[i][C-1] =board[i+1][C-1];
		}
		board[upR-1][C-1] = tmp1;
		
		// 우 -> 좌
		tmp1 = board[0][0];
		for(int j=0;j<C-2;j++) {
			board[0][j] = board[0][j+1];
		}
		board[0][C-2] = tmp2;
		
		// 상->하
		for(int i=upR-1;i>0;i--) {
			board[i][0] = board[i-1][0];
		}
		board[1][0] = tmp1;
	}
	// 아래쪽 순환 
		static void downCycle() {
			// 좌-> 우 
			int tmp1 = board[downR][C-1];
			for(int j=C-2;j>0;j--) {
				board[downR][j+1] = board[downR][j];
			}
			board[downR][1] = 0;

			// 상->하
			int tmp2 = board[R-1][C-1];
			for(int i=R-1;i>downR+1;i--) {
				board[i][C-1] = board[i-1][C-1];
			}
			board[downR+1][C-1] = tmp1;
			
			// 우 -> 좌
			tmp1 = board[R-1][0];
			for(int j=0;j<C-1;j++) {
				board[R-1][j] = board[R-1][j+1];
			}
			board[R-1][C-2] = tmp2;

			// 하 -> 상 
			for(int i=downR+1;i<R-1;i++) {
				board[i][0] =board[i+1][0];
			}
			board[R-2][0] = tmp1;
			
			
		}
}

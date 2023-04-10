import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	static class Pair{
		int x,y,z;

		
		public Pair() {
			super();
		}


		public Pair(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Pair> q = new ArrayDeque<>();

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][][] board = new int[M][N][H];
		
		int isAll = 0;
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<M;k++) {
					int num = Integer.parseInt(st.nextToken());
					board[k][j][i] = num;
					// x y z
					if(num==1) q.add(new Pair(k,j,i));
					else if(num==0) isAll++;
				}
			}
		}
		if(isAll == 0) q = new ArrayDeque<>();
		
		int[] dx = {1, -1, 0, 0, 0, 0};
		int[] dy = {0, 0, 1, -1, 0, 0};
		int[] dz = {0, 0, 0, 0, 1, -1};
		// bfs
		int time = 0;
		while(!q.isEmpty()) {
			Pair c = q.poll();
			for(int d=0;d<6;d++) {
				int nx = dx[d]+c.x;
				int ny = dy[d]+c.y;
				int nz = dz[d]+c.z;
				
				if(nx<0 || nx>=M ||ny<0 || ny>=N||nz<0 || nz>=H ) continue;
				if(board[nx][ny][nz] != 0) continue;
				
				// board[nx][ny][nx] 가 0인 경우( 안 익은 토마토)
				board[nx][ny][nz] = board[c.x][c.y][c.z]+1;
				time = board[c.x][c.y][c.z];
				q.add(new Pair(nx,ny,nz));
			}
		}
		
		boolean isZero = false;
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					if(board[k][j][i] == 0) {
						isZero = true;
						break;
					}
				}
			}
		}
		if(isZero) System.out.println(-1);
		else System.out.println(time);
		
	}
}
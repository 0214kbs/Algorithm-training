
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int RGB = 0;
	static int RG_B = 0;

	static boolean[][] visit,visit2;
	static int N;
	public static void main(String[] args)throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[][] board = new char[N][];
		char[][] board2 = new char[N][N];
		visit = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			board[i] = br.readLine().toCharArray();
			for(int j=0;j<N;j++) {
				board2[i][j] = (board[i][j]=='R')?'G': board[i][j];
			}
			//System.out.println(Arrays.toString(board2[i]));
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visit[i][j]) {
					check(i, j, board[i][j],board);
					RGB++;
				}
			}
		}
		System.out.print(RGB+" ");

		visit = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visit[i][j]) {
					check(i, j, board2[i][j],board2);
					RG_B++;
				}
			}
		}
		System.out.println(RG_B);
	}
	
	static void check(int i, int j,char c,char[][] map) {
		int[] dy = {1,-1,0,0};
		int[] dx = {0,0,1,-1};
		
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d=0;d<4;d++) {
				int ny = dy[d]+cur[0];
				int nx = dx[d]+cur[1];
				if(ny<0 || nx<0 || ny>=N || nx>=N|| visit[ny][nx]) continue;
				
				if(map[ny][nx] == c) {
					visit[ny][nx] = true;
					q.offer(new int[] {ny,nx});
				}
				
			}
		}
		return;
	}
	
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			char[] ch = str.toCharArray();
			
			for(int j = 0 ; j < ch.length ; j++) {
				board[i][j] = Character.getNumericValue(ch[j]);
			}
		}
		
		
		// bfs
		int[] dr = {0,0,-1,1};
		int[] dc = {1,-1,0,0};
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[]{0,0});
		visit[0][0] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d=0;d<4;d++) {
				int nr = dr[d]+cur[0];
				int nc = dc[d]+cur[1];
				if(nr<0 || nc<0 || nr>=N || nc>=M || visit[nr][nc] || board[nr][nc] ==0) continue;
				q.offer(new int[] {nr,nc});
				board[nr][nc] = board[cur[0]][cur[1]] +1;
				visit[nr][nc] = true;
			}
			
		}
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++) {
//				System.out.print(board[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.println(board[N-1][M-1]);
		
	}
}

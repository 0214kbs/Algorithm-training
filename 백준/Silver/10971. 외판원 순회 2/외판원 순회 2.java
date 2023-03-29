import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] board;
	static int minV = Integer.MAX_VALUE;
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		visit = new boolean[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			visit[i] = true;
			tsp(i,i,0,0);
			visit[i] = false;
		}
		
		if(minV == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(minV);
	}
	
	static void tsp(int start, int now, int cnt, int cost ) {
		if(cnt == N-1) {
			if(board[now][start] == 0) return;
			minV = Math.min(minV, cost+board[now][start]);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!visit[i]&&board[now][i]!=0) {
				visit[i] = true;
				tsp(start,i, cnt+1,cost+board[now][i]);
				visit[i] = false;
			}
		}
	}
}
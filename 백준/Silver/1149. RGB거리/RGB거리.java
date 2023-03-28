import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n+1][3];
		
		
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			board[i][0] = Math.min(board[i-1][1], board[i-1][2]) + r;
            board[i][1] = Math.min(board[i-1][0], board[i-1][2]) + g;
            board[i][2] = Math.min(board[i-1][0], board[i-1][1]) + b;
		}
		
		System.out.println(Math.min(board[n][0], Math.min(board[n][1], board[n][2])));
	}
}
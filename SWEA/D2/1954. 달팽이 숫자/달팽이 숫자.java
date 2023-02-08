
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	static int[][] board;
	static int[] dx = { 0, 1, 0, -1 }; // right down left up
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			board = new int[n][n];
			
			int x = 0;
			int y = 0;
			int cnt = 1;
			int d = 0;
			
			for (int i = 1; i <= n*n; i++) { 
				board[x][y] = i;
				if (x + dx[d] >= n || x + dx[d] < 0 || y + dy[d] >= n || y + dy[d] < 0
						|| board[x + dx[d]][y + dy[d]] != 0) {
					d = (d + 1) % 4; 
				}
				x += dx[d];
				y += dy[d];
			}

			// output
//			StringBuilder sb = new StringBuilder();
//			sb.append("#").append(t).append("\n");
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					sb.append(board[i][j]).append(" ");
//				}
//				sb.append("\n");
//			}
//			System.out.println(sb);
			System.out.println("#" + t);
			for (int i = 0; i < n; i++) {
				for (int b : board[i])
					System.out.print(b + " ");
				System.out.println();
			}
		}
	}
}
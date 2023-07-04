import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] list = new int[n + 1][n + 1];
		int[][] dp = new int[n + 1][n + 1];
		int[] paint = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j) dp[1][j] = list[1][j];
				else dp[1][j] = 1001;
			}

			for (int k = 2; k < n + 1; k++) {
				dp[k][0] = Math.min(dp[k - 1][1], dp[k - 1][2]) + list[k][0];
				dp[k][1] = Math.min(dp[k - 1][0], dp[k - 1][2]) + list[k][1];
				dp[k][2] = Math.min(dp[k - 1][0], dp[k - 1][1]) + list[k][2];
				if (k == n) {
					switch (i) {
					case 0:
						paint[i] = Math.min(dp[n][1], dp[n][2]);
						break;
					case 1:
						paint[i] = Math.min(dp[n][0], dp[n][2]);
						break;
					case 2:
						paint[i] = Math.min(dp[n][0], dp[n][1]);
						break;

					}
				}

			}

		}
		System.out.println(Math.min(paint[0], Math.min(paint[1], paint[2])));
	}
}
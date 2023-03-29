import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	private static int full, N, INF = 17 * 1000000 + 1;
	private static int[][] map, dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String input[];
		map = new int[N][N];
		full = (1 << N) - 1;
		dp = new int[N][full];
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if (map[i][j] == 0) map[i][j] = INF;
			}
		}
		System.out.println(dfs(0, 1));
	}
	private static int dfs(int curr, int visited) {
		if (visited == full) return map[curr][0];
		if (dp[curr][visited] != 0) return dp[curr][visited];
        int res = INF;
		for (int i = 0; i < N; i++) {
			if (map[curr][i] == INF || (visited & (1 << i)) != 0) continue;
			res = Math.min(res, dfs(i, visited | (1 << i)) + map[curr][i]);
		}
		return dp[curr][visited] = res;
	}
}
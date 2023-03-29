class Main {
	
	private static int[][] map, dp;
	private static int full, N, INF = 17 * 1000000 + 1;
	
	public static void main(String[] args) throws Exception {
		N = read();
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = read();
				
				if (map[i][j] == 0) {
					map[i][j] = INF;
				}
			}
		}
		
		full = (1 << N) - 1;
		dp = new int[N][full];
		
		System.out.print(dfs(0, 1));
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		return n;
	}
	
	private static int dfs(int curr, int visited) {
		if (visited == full) {
			return map[curr][0];
		}
		
		if (dp[curr][visited] != 0) {
			return dp[curr][visited];
		}
		
        int res = INF;
        
		for (int i = 0; i < N; i++) {
			if (map[curr][i] == INF || (visited & (1 << i)) != 0) {
				continue;
			}
			
			res = Math.min(res, dfs(i, visited | (1 << i)) + map[curr][i]);
		}
		
		return dp[curr][visited] = res;
	}
}

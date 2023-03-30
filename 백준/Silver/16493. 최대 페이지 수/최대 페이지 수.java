class Main {
	public static void main(String[] args) throws Exception {
		int N = read();
		int M = read();
		
		int[][] dp = new int[M + 1][N + 1];
		int[] day = new int[M + 1];
		int[] page = new int[M + 1];
		
		for (int i = 1; i <= M; i++) {
			day[i] = read();
			page[i] = read();
		}
		
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				if (day[i] > j) {
					dp[i][j] = dp[i - 1][j];
					
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - day[i]] + page[i]);
				}
			}
		}
		
		System.out.print(dp[M][N]);
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		return n;
	}
}

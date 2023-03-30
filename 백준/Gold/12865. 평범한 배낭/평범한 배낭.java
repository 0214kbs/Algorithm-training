
class Main {
	public static void main(String[] args) throws Exception {
		int N = read();
		int K = read();
		
		int[][] dp = new int[N + 1][K + 1];
		int[] weight = new int[N + 1];
		int[] value = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			weight[i] = read();
			value[i] = read();
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (weight[i] > j) {
					dp[i][j] = dp[i - 1][j];
					
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
				}
			}
		}
		
		System.out.print(dp[N][K]);
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		return n;
	}
}

class Main {
	public static void main(String[] args) throws Exception {
		int N = read();
		
		int[][] dp = new int[N + 1][100];
		int[] health = new int[N + 1];
		int[] pleasure = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			health[i] = read();
		}
		
		for (int i = 1; i <= N; i++) {
			pleasure[i] = read();
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < 100; j++) {
				if (health[i] > j) {
					dp[i][j] = dp[i - 1][j];
					
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - health[i]] + pleasure[i]);
				}
			}
		}
		
		System.out.print(dp[N][99]);
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		return n;
	}
}

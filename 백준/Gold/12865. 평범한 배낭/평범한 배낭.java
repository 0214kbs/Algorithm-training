class Main {
	public static void main(String[] args) throws Exception {
		int N = read();
		int K = read();
		
		int[] dp = new int[K + 1];
		
		for (int i = 0; i < N; i++) {
			int w = read();
			int v = read();
			
			for (int j = K; j >= w; j--) {
				if (dp[j] < dp[j - w] + v) {
					dp[j] = dp[j - w] + v;
				}
			}
		}
		
		System.out.print(dp[K]);
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		return n;
	}
}

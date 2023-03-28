class Main {
	public static void main(String[] args) throws Exception {
		int N = read();
		int[] dp = new int[N + 1];
		
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;
			
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1); 
			}
			
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1); 
			}
		}
		
		System.out.println(dp[N]);
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		return n;
	}
}

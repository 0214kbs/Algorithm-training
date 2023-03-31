class Main {
	
	private static int[] dp;
	private static int N, answer;
	
	public static void main(String[] args) throws Exception {
		N = read();
		
		dp = new int[N];
		dp[0] = read();
		
		while (N-- > 1) {
			int num = read();
			
			if (dp[answer] < num) {
				dp[++answer] = num;
				
			} else {
				binarySearch(num);
			}
		}
		
		System.out.println(answer + 1);
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		boolean isNegative = n == 13;
		
		if (isNegative) {
			n = System.in.read() & 15;
		}
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		return isNegative ? ~n + 1 : n;
	}
	
	private static void binarySearch(int num) {
		int start = 0;
		int end = answer;
		
		while (start <= end) {
			int mid = (start + end) >> 1;
			
			if (dp[mid] < num) {
				start = mid + 1;
				
			} else if (dp[mid] > num) {
				end = mid - 1;
				
			} else {
				return;
			}
		}
		
		dp[start] = num;
	}
}

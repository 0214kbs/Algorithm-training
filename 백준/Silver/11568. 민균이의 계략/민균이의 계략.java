class Main {
	
	private static int[] arr, dp;
	private static int N, answer;
	
	public static void main(String[] args) throws Exception {
		N = read();
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = read();
		}
		
		dp = new int[N];
		dp[0] = arr[0];
		
		for (int i = 1; i < N; i++) {
			if (dp[answer] < arr[i]) {
				dp[++answer] = arr[i];
				
			} else {
				binarySearch(arr[i]);
			}
		}
		
		System.out.print(answer + 1);
	}
	
	private static int read() throws Exception {
    	int c, n = System.in.read() & 15;
    	
    	while ((c = System.in.read()) > 32) {
    		n = (n << 3) + (n << 1) + (c & 15);
    	}
    	
    	return n;
    }
	
	private static void binarySearch(int num) {
		int start = 0;
		int end = answer;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			
			if (dp[mid] < num) {
				start = mid + 1;
				
			} else {
				if (dp[mid] == num) {
					return;
				}
				
				end = mid - 1;
			}
		}
		
		dp[start] = num;
	}
}

class Main {
	public static void main(String[] args) throws Exception {
		int N = read();
		int S = read();
		int[] arr = new int[N + 1];
		
		for (int i = 0; i < N; i++) {
			arr[i] = read();
		}
		
		int min = Integer.MAX_VALUE;
		int left = 0;
		int right = 0;
		int sum = 0;
		
		while (right <= N) {
			if (sum >= S) {
				sum -= arr[left++];
				
				if (right - left + 1 < min) {
					min = right - left + 1;
				}
				
			} else {
				sum += arr[right++];
			}
		}
		
		System.out.print(min == Integer.MAX_VALUE ? 0 : min);
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		return n;
	}
}

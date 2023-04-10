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
		int total = 0;
		
		while (right <= N) {
			if (total >= S && right - left < min) {
				min = right - left;
			}
			
			if (total < S) {
				total += arr[right++];
				
			} else {
				total -= arr[left++];
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

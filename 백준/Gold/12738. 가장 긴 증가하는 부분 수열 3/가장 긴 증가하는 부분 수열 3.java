class Main {
	
	private static int[] dp;
	private static int N, answer;
	
	public static void main(String[] args) throws Exception {
		Reader sc = new Reader();
		N = sc.nextInt();
		
		dp = new int[N];
		dp[0] = sc.nextInt();
		
		while (N-- > 1) {
			int num = sc.nextInt();
			
			if (dp[answer] < num) {
				dp[++answer] = num;
				
			} else {
				binarySearch(num);
			}
		}
		
		System.out.println(answer + 1);
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
	
	static class Reader {
		final int SIZE = 1 << 13;
		byte[] buffer = new byte[SIZE];
		int index, size;

		int nextInt() throws Exception {
			int n = 0;
			byte c;
			while ((c = read()) <= 32);
			boolean neg = c == '-' ? true : false;
			if (neg)
				c = read();
			do n = (n << 3) + (n << 1) + (c & 15);
			while (isNumber(c = read()));
			if (neg)
				return -n;
			return n;
		}

		boolean isNumber(byte c) {
			return 47 < c && c < 58;
		}

		byte read() throws Exception {
			if (index == size) {
				size = System.in.read(buffer, index = 0, SIZE);
				if (size < 0)
					buffer[0] = -1;
			}
			return buffer[index++];
		}
	}
}

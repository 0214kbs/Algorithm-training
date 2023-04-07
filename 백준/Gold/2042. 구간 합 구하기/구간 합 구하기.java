class Main {
	
	private static long[] bit, arr;
	private static int N, MK;
	
	public static void main(String[] args) throws Exception {
		N = readInt();
		MK = readInt() + readInt();
		
		bit = new long[N + 1];
		arr = new long[N + 1];
		
		for (int i = 1; i <= N; i++) {
			update(i, readLong());
		}
		
		StringBuilder sb = new StringBuilder();
		
		while (MK-- > 0) {
			switch (readInt()) {
				case 1: update(readInt(), readLong()); break;
				case 2: sb.append(query(readInt(), readInt())).append('\n'); break;
			}
		}
		
		System.out.print(sb);
	}
	
	private static int readInt() throws Exception {
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
	
	private static long readLong() throws Exception {
		long n = System.in.read() & 15;
		int c;
		
		boolean isNegative = n == 13;
		
		if (isNegative) {
			n = System.in.read() & 15;
		}
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		return isNegative ? ~n + 1 : n;
	}
	
	private static long query(int b, int c) {
		return getPrefixSum(c) - getPrefixSum(b - 1);
	}
	
	private static long getPrefixSum(int target) {
		long answer = 0;
		
		while (target > 0) {
			answer += bit[target];
			target -= target & -target;
		}
		
		return answer;
	}
	
	private static void update(int target, long value) {
		long diff = value - arr[target];
		arr[target] = value;
		
		while (target <= N) {
			bit[target] += diff;
			target += target & -target;
		}
	}
}

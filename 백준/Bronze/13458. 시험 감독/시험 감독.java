class Main {
	public static void main(String[] args) throws Exception {
		int N = read();
		int[] A = new int[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = read();
		}
		
		int B = read();
		int C = read();
		
		long answer = 0;
		
		for (int i = 0; i < N; i++) {
			A[i] -= B;
			answer++;
		}
		
		for (int i = 0; i < N; i++) {
			if (A[i] > 0) {
				if (A[i] % C == 0) {
					answer += A[i] / C;
					
				} else {
					answer += A[i] / C + 1;
				}
			}
		}
		
		System.out.println(answer);
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		return n;
	}
}

class Main {
	public static void main(String[] args) throws Exception {
		int L = read();
		byte[] buffer = new byte[L + 2];
		
		System.in.read(buffer);
		
		long sum = 0;
		int M = 1234567891;
		
		for (int i = 0; i < L; i++) {
			sum += (buffer[i] - 96) * Math.pow(31, i) % M;
		}
		
		System.out.print(sum);
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		return n;
	}
}

class Main {
	
	private static int[] sang, sun;
	private static int N, M;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		
		while ((N = read()) != 0 && (M = read()) != 0) {
			sang = new int[N];
			sun = new int[M];
			
			for (int i = 0; i < N; i++) {
				sang[i] = read();
			}
			
			for (int i = 0; i < N; i++) {
				sun[i] = read();
			}
			
			int answer = 0;
			
			for (int i = 0; i < N; i++) {
				if (binarySearch(sang[i])) {
					answer++;
				}
			}
			
			sb.append(answer).append('\n');
		}
		
		System.out.println(sb);
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		return n;
	}
	
	private static boolean binarySearch(int target) {
		int start = 0;
		int end = M;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			
			if (sun[mid] < target) {
				start = mid + 1;
				
			} else if (sun[mid] > target) {
				end = mid - 1;
				
			} else {
				return true;
			}
				
		}
		
		return false;
	}
}

class Main {
	public static void main(String[] args) throws Exception {
		int N = read();
		int d = read();
		int k = read();
		int c = read();
		
		int[] arr = new int[N + k];
		
		for (int i = 0; i < N; i++) {
			arr[i] = read();
		}
		
		for (int i = N; i < N + k; i++) {
			arr[i] = arr[i - N];
		}
		
		int[] visited = new int[d + 1];
		int count = 1;
		visited[c] = 1;
		
		for (int i = 0; i < k; i++) {
			if (visited[arr[i]] == 0) {
				count++;
			}
			
			visited[arr[i]]++;
		}
		
		int max = count;
		
		for (int i = k; i < N + k; i++) {
			if (arr[i - k] == arr[i]) {
				continue;
			}
			
			visited[arr[i - k]]--;
			
			if (visited[arr[i - k]] == 0) {
				count--;
			}
			
			if (visited[arr[i]] == 0) {
				count++;
			}
			
			visited[arr[i]]++;
			
			if (count > max) {
				max = count;
			}
		}
		
		System.out.print(max);
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		return n;
	}
}

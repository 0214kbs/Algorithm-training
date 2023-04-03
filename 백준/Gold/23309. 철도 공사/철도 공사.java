class Main {
	
	public static void main(String[] args) throws Exception {
		int[] prev = new int[1000001];
		int[] next = new int[1000001];
		
		int N = read();
		int M = read();
		
		int start = read();
		int before = start;
		
		while (N-- > 2) {
			int curr = read();
			prev[curr] = before;
			next[before] = curr;
			before = curr;
		}
		
		int end = read();
		prev[end] = before;
		next[before] = end;
		prev[start] = end;
		next[end] = start;
		
		StringBuilder sb = new StringBuilder();
		
		while (M-- > 0) {
			int cmd = read();
			int i = read();
			int j = 0, temp = 0;
			
			switch (cmd) {
				case 34:
					j = read();
					temp = next[i];
					next[i] = j;
					next[j] = temp;
					prev[j] = i;
					prev[temp] = j;
					
					break;
					
				case 20:
					j = read();
					temp = prev[i];
					prev[i] = j;
					prev[j] = temp;
					next[j] = i;
					next[temp] = j;
					
					break;
					
				case 44:
					temp = next[i];
					next[i] = next[temp];
					prev[next[i]] = i;
					
					break;
					
				case 30:
					temp = prev[i];
					prev[i] = prev[temp];
					next[prev[i]] = i;
					
					break;
			}
			
			sb.append(temp).append('\n');
		}
		
		System.out.print(sb);
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		return n;
	}
}

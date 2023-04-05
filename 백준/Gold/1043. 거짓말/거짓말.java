class Main {
	
	private static int[] parent;
	private static int N;
	
	public static void main(String[] args) throws Exception {
		N = read();
		int M = read();
		int n = read();
		
		makeSet();
		
		for (int i = 0; i < n; i++) {
			union(0, read());
		}
		
		int[][] party = new int[M][];
		
		for (int i = 0; i < M; i++) {
			n = read();
			party[i] = new int[n];
			
			for (int j = 0; j < n; j++) {
				party[i][j] = read();
				union(party[i][0], party[i][j]);
			}
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < party[i].length; j++) {
				union(party[i][0], party[i][j]);
			}
		}
		
		int answer = M;
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < party[i].length; j++) {
				if (parent[party[i][j]] > 0) {
					continue;
				}
				
				answer--;
				break;
			}
		}
		
		System.out.print(answer);
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		return n;
	}
	
	private static void makeSet() {
		parent = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}
	
	private static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if (px == py) {
			return;
		}
		
		if (px < py) {
			parent[py] = px;
			
		} else {
			parent[px] = py;
		}
	}
	
	private static int findSet(int x) {
		if (x == parent[x]) {
			return x;
		}
		
		return parent[x] = findSet(parent[x]);
	}
}

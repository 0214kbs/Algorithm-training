class Main {
	
	private static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	private static Point[] points;
	private static int n;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int t = read();
		
		while (t-- > 0) {
			n = read();
			points = new Point[n + 2];
			
			for (int i = 0; i < n + 2; i++) {
				points[i] = new Point(read(), read());
			}
			
			sb.append(bfs());
		}
		
		System.out.print(sb);
	}
	
	private static int read() throws Exception {
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
	
	private static String bfs() {
		Point[] queue = new Point[n + 2];
		boolean[] visited = new boolean[n + 2];
		int head = 0;
		int tail = -1;
		
		queue[++tail] = points[0];
		visited[0] = true;
		
		while (tail > head - 1) {
			int size = tail - head + 1;
			
			while (size-- > 0) {
				Point curr = queue[head++];
				
				for (int i = 1; i < n + 2; i++) {
					if (visited[i] || Math.abs(curr.r - points[i].r) + Math.abs(curr.c - points[i].c) > 1000) {
						continue;
					}
					
					if (i == n + 1) {
						return "happy\n";
					}
					
					queue[++tail] = points[i];
					visited[i] = true;
				}
			}
		}
		
		return "sad\n";
	}
}

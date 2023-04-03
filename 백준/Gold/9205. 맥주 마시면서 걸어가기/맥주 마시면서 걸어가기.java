import java.util.ArrayDeque;
import java.util.Queue;

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
	private static boolean[][] distance;
	private static int n;
	
	public static void main(String[] args) throws Exception {
		int t = read();
		
		while (t-- > 0) {
			n = read();
			points = new Point[n + 2];
			
			for (int i = 0; i < n + 2; i++) {
				points[i] = new Point(read(), read());
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append(bfs() ? "happy\n" : "sad\n");
			
			System.out.print(sb);
		}
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
	
	private static boolean bfs() {
		distance = new boolean[n + 2][n + 2];
		
		for (int i = 0; i < n + 2; i++) {
			for (int j = i + 1; j < n + 2; j++) {
				if (Math.abs(points[i].r - points[j].r) + Math.abs(points[i].c - points[j].c) <= 1000) {
					distance[i][j] = distance[j][i] = true;
				}
			}
		}
		
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[n + 2];
		
		queue.offer(0);
		visited[0] = true;
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			
			if (curr == n + 1) {
				return true;
			}
			
			for (int i = 1; i < n + 2; i++) {
				if (i == curr || visited[i] || !distance[curr][i]) {
					continue;
				}
				
				queue.offer(i);
				visited[i] = true;
			}
		}
		
		return false;
	}
}

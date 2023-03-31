import java.util.ArrayDeque;
import java.util.Queue;

class Main {
	
	private static class Point {
		int r;
		int c;
		int v;
		
		public Point(int r, int c, int v) {
			this.r = r;
			this.c = c;
			this.v = v;
		}
	}
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	private static boolean[][] visited;
	private static int[][] map;
	private static int N, M;
	
	public static void main(String[] args) throws Exception {
		N = read();
		M = read();
		
		Queue<Point> queue = new ArrayDeque<>();
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = read();
				
				if (map[i][j] > 0) {
					queue.offer(new Point(i, j, map[i][j]));
				}
			}
		}
		
		int time = 1;
		
		while (true) {
//			System.out.println("===================");
//			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				
//				System.out.println();
//			}
//			
//			System.out.println("===================");
			
			int size = queue.size();
			
			if (size == 0) {
				System.out.print(0);
				return;
			}
			
			while (size-- > 0) {
				Point curr = queue.poll();
				
				for (int i = 0; i < 4; i++) {
					if (curr.v == 0) {
						break;
					}
					
					int nr = curr.r + dr[i];
					int nc = curr.c + dc[i];
					
					if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] > 0) {
						continue;
					}
					
					curr.v--;
				}
				
				queue.offer(curr);
			}
			
			size = queue.size();
			
			while (size-- > 0) {
				Point curr = queue.poll();
				map[curr.r][curr.c] = curr.v;
				
				if (curr.v > 0) {
					queue.offer(curr);
				}
			}
			
			visited = new boolean[N][M];
			int count = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] > 0 && !visited[i][j]) {
						bfs(i, j);
						count++;
					}
				}
			}
			
			if (count > 1) {
				System.out.print(time);
				return;
			}
			
//			System.out.println("===================");
//			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					if (visited[i][j]) {
//						System.out.print(1 + " ");
//					} else {
//						System.out.print(0 + " ");
//					}
//				}
//				
//				System.out.println();
//			}
//			
//			System.out.println("===================");
			
			time++;
		}
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		return n;
	}
	
	private static void bfs(int r, int c) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(r, c, 0));
		visited[r][c] = true;
		
		while (queue.size() > 0) {
			Point curr = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == 0) {
					continue;
				}
				
				queue.offer(new Point(nr, nc, 0));
				visited[nr][nc] = true;
			}
		}
	}
}

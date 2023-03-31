import java.util.ArrayDeque;
import java.util.Queue;

class Main {
	
	public static class Point {
		int r;
		int c;
		int mask;
		int count;
		
		public Point(int r, int c, int mask, int count) {
			this.r = r;
			this.c = c;
			this.mask = mask;
			this.count = count;
		}
	}
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	private static boolean[][][] visited;
	private static byte[][] map;
	private static int N, M;
	
	public static void main(String[] args) throws Exception {
		N = read();
		M = read();
		map = new byte[N][M + 1];
		
		int startR = 0;
		int startC = 0;
		
		for (int i = 0; i < N; i++) {
			System.in.read(map[i]);
			
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 48) {
					startR = i;
					startC = j;
				}
			}
		}
		
		visited = new boolean[(1 << 6)][N][M];
		System.out.print(bfs(startR, startC));
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		return n;
	}
	
	private static int bfs(int r, int c) {
		Queue<Point> queue = new ArrayDeque<>();
		
		queue.offer(new Point(r, c, 0, 0));
		visited[0][r][c] = true;
		
		while (!queue.isEmpty()) {
			Point curr = queue.poll();
			
			if (map[curr.r][curr.c] == 49) {
				return curr.count;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				int nm = curr.mask;
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 35 || visited[nm][nr][nc]) {
					continue;
				}
				
				if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
					if ((nm & (1 << (map[nr][nc] - 'A'))) == 0) {
						continue;
						
					}
					
				} else if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
					nm |= (1 << (map[nr][nc] - 'a'));
				}
				
				queue.offer(new Point(nr, nc, nm, curr.count + 1));
				visited[nm][nr][nc] = true;
			}
		}
		
		return -1;
	}
}

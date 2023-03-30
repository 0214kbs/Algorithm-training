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
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	private static Queue<Point> queue;
	private static Point[] points;
	private static boolean[][] visited;
	private static int[][] map;
	private static int[][] copy;
	private static int N, M, answer;
	
	public static void main(String[] args) throws Exception {
		answer = 0;
		N = read();
		M = read();
		
		points = new Point[N * M];
		map = new int[N][M];
		
		int index = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				points[index++] = new Point(i, j);
				map[i][j] = read();
			}
		}
		
		queue = new ArrayDeque<>();
		
		for (int i = 0; i < N * M; i++) {
			if (map[points[i].r][points[i].c] != 0) {
				continue;
			}
			
			map[points[i].r][points[i].c] = 1;
			
			for (int j = i + 1; j < N * M; j++) {
				if (map[points[j].r][points[j].c] != 0) {
					continue;
				}
				
				map[points[j].r][points[j].c] = 1;
				
				for (int k = j + 1; k < N * M; k++) {
					if (map[points[k].r][points[k].c] != 0) {
						continue;
					}
					
					map[points[k].r][points[k].c] = 1;
					
					visited = new boolean[N][M];
					copy = new int[N][M];
					
					for (int r = 0; r < N; r++) {
						for (int c = 0; c < M; c++) {
							copy[r][c] = map[r][c];
						}
					}
					
					for (int r = 0; r < N; r++) {
						for (int c = 0; c < M; c++) {
							if (map[r][c] == 2 && !visited[r][c]) {
								bfs(r, c);
							}
						}
					}
					
					int count = 0;
					
					for (int r = 0; r < N; r++) {
						for (int c = 0; c < M; c++) {
							if (copy[r][c] == 0) {
								count++;
							}
						}
					}
					
					if (count > answer) {
						answer = count;
					}
					
					map[points[k].r][points[k].c] = 0;
				}
				
				map[points[j].r][points[j].c] = 0;
			}
			
			map[points[i].r][points[i].c] = 0;
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
	
	private static void bfs(int r, int c) {
		queue.offer(new Point(r, c));
		visited[r][c] = true;
		
		while (!queue.isEmpty()) {
			Point curr = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || copy[nr][nc] == 1) {
					continue;
				}
				
				queue.offer(new Point(nr, nc));
				visited[nr][nc] = true;
				copy[nr][nc] = 2;
			}
		}
	}
}

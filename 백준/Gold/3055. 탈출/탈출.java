import java.util.Arrays;
import java.util.LinkedList;
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
	
	private static Queue<Point> water;
	private static Queue<Point> hedgehog;
	private static boolean[][] visitedWater;
	private static boolean[][] visitedHedgehog;
	private static byte[][] map;
	private static int R, C, answer;
	
	public static void main(String[] args) throws Exception {
		R = read();
		C = read();
		
		water = new LinkedList<>();
		hedgehog = new LinkedList<>();
		map = new byte[R][C + 1];
		
		for (int i = 0; i < R; i++) {
			System.in.read(map[i]);
			
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 42) {
					water.offer(new Point(i, j));
					
				} else if (map[i][j] == 83) {
					hedgehog.offer(new Point(i, j));
				}
			}
		}
		
		visitedWater = new boolean[R][C];
		visitedHedgehog = new boolean[R][C];
		
		while (true) {
			answer++;
			moveWater();
			moveHedgehog();
		}
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		return n;
	}
	
	private static void moveWater() {
		int size = water.size();
		
		while (size-- > 0) {
			Point curr = water.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				
				if (nr < 0 || nr >= R || nc < 0 || nc >= C || visitedWater[nr][nc] || map[nr][nc] != 46) {
					continue;
				}
				
				water.offer(new Point(nr, nc));
				visitedWater[nr][nc] = true;
				map[nr][nc] = 42;
			}
		}
	}
	
	private static void moveHedgehog() {
		int size = hedgehog.size();
		
		if (size == 0) {
			System.out.print("KAKTUS");
			System.exit(0);
		}
		
		while (size-- > 0) {
			Point curr = hedgehog.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				
				if (nr < 0 || nr >= R || nc < 0 || nc >= C || visitedHedgehog[nr][nc]) {
					continue;
				}
				
				if (map[nr][nc] == 68) {
					System.out.print(answer);
					System.exit(0);
					
				} else if (map[nr][nc] == 46) {
					hedgehog.offer(new Point(nr, nc));
					visitedHedgehog[nr][nc] = true;
					map[nr][nc] = 46;
				}
			}
		}
	}
}

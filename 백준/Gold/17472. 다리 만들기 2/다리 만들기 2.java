class Main {
	
	private static class Heap {
		Bridge[] heap;
		int size;
		
		public Heap(int size) {
			this.heap = new Bridge[size + 1];
		}
		
		void offer(Bridge x) {
			heap[++size] = x;
			int i = size;
			
			while ((i >>= 1) > 1) {
				if (!swap(i)) {
					break;
				}
			}
		}
		
		Bridge poll() {
			Bridge x = heap[1];
			heap[1] = heap[size--];
			int i = 1;
			
			while ((i <<= 1) <= size) {
				if (i < size && heap[i + 1].distance < heap[i].distance) {
					i++;
				}
				
				if (!swap(i)) {
					break;
				}
			}
			
			return x;
		}
		
		boolean swap(int i) {
			int j = i >> 1;
			Bridge parent = heap[j];
			Bridge child = heap[i];
			
			if (parent.distance < child.distance) {
				return false;
			}
			
			heap[j] = child;
			heap[i] = parent;
			
			return true;
		}
	}
	
	private static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	private static class Bridge {
		int from;
		int to;
		int distance;
		
		public Bridge(int from, int to, int distance) {
			this.from = from;
			this.to = to;
			this.distance = distance;
		}
	}
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	private static Heap bridges;
	private static int[][] island;
	private static int[][] map;
	private static int[] parent;
	private static int N, M, islandCount;
	
	public static void main(String[] args) throws Exception {
		N = read();
		M = read();
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = read();
			}
		}
		
		island = new int[N][M];
		islandCount = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 || island[i][j] > 0) {
					continue;
				}
				
				islandCount++;
				getIslandCount(i, j);
			}
		}
		
		bridges = new Heap(N * M * 4);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					continue;
				}
				
				findBridge(i, j, map[i][j]);
			}
		}
		
		makeSet();
		
		int result = 0;
		int count = 0;
		
		while (bridges.size > 0) {
			Bridge bridge = bridges.poll();
			
			if (union(bridge.from, bridge.to)) {
				result += bridge.distance;
				
				if (++count == islandCount - 1) {
					break;
				}
			}
		}
		
		System.out.println(count == islandCount - 1 ? result : -1);
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		return n;
	}
	
	private static void getIslandCount(int r, int c) {
		Point[] queue = new Point[N * M];
		int head = 0, tail = -1;
		
		queue[++tail] = new Point(r, c);
		island[r][c] = islandCount;
		
		while (tail > head - 1) {
			Point curr = queue[head++];
			
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || island[nr][nc] > 0 || map[nr][nc] == 0) {
					continue;
				}
				
				queue[++tail] = new Point(nr, nc);
				island[nr][nc] = islandCount;
			}
		}
	}
	
	private static void findBridge(int r, int c, int number) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			int count = 0;
			
			while (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
				nr += dr[i];
				nc += dc[i];
				count++;
			}
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
				continue;
			}
			
			if (count > 1) {
				bridges.offer(new Bridge(island[r][c], island[nr][nc], count));
			}
		}
	}
	
	private static void makeSet() {
		parent = new int[islandCount + 1];
		
		for (int i = 1; i <= islandCount; i++) {
			parent[i] = i;
		}
	}
	
	private static int findSet(int x) {
		if (parent[x] == x) {
			return x;
		}
		
		return parent[x] = findSet(parent[x]);
	}
	
	private static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if (px == py) {
			return false;
		}
		
		parent[py] = px;
		return true;
	}
}

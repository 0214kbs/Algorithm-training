class Main {
	
	private static class Point {
		int r;
		int c;
		int cost;
		
		public Point(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
	}
	
	private static class Heap {
		Point[] heap;
		int size;
		
		public Heap(int size) {
			this.heap = new Point[size + 1];
		}
		
		void offer(Point x) {
			heap[++size] = x;
			int i = size << 1;
			
			while ((i >>= 1) > 1) {
				if (!swap(i)) {
					break;
				}
			}
		}
		
		Point poll() {
			Point x = heap[1];
			heap[1] = heap[size--];
			int i = 1;
			
			while ((i <<= 1) <= size) {
				if (i < size && heap[i + 1].cost < heap[i].cost) {
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
			Point parent = heap[j];
			Point child = heap[i];
			
			if (parent.cost < child.cost) {
				return false;
			}
			
			heap[j] = child;
			heap[i] = parent;
			
			return true;
		}
	}
	
	private static final int INF = Integer.MAX_VALUE;
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	private static Heap heap;
	private static int[][] distance;
	private static int[][] map;
	private static int N;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int t = 1;
		
		while ((N = read()) > 0) {
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = read();
				}
			}
			
			sb.append("Problem ").append(t++).append(": ").append(dijktra()).append('\n');
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
	
	private static int dijktra() {
		heap = new Heap(N * N);
		distance = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				distance[i][j] = INF;
			}
		}
		
		heap.offer(new Point(0, 0, map[0][0]));
		distance[0][0] = map[0][0];
		
		while (heap.size > 0) {
			Point curr = heap.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
					continue;
				}
				
				if (distance[nr][nc] > distance[curr.r][curr.c] + map[nr][nc]) {
					distance[nr][nc] = distance[curr.r][curr.c] + map[nr][nc];
					heap.offer(new Point(nr, nc, distance[nr][nc]));
				}
			}
		}
		
		return distance[N - 1][N - 1];
	}
}

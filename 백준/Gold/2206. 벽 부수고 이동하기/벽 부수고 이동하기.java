class Main {

    static class Point {
        int r;
        int c;
        int step;
        int isCrushed;

        public Point(int r, int c, int step, int isCrushed) {
            this.r = r;
            this.c = c;
            this.step = step;
            this.isCrushed = isCrushed;
        }
    }
    
    private static int[] dr = {0, 1, 0, -1};
    private static int[] dc = {1, 0, -1, 0};
    
    private static boolean[][][] visited;
    private static byte[][] map;
    private static int N, M;

    public static void main(String[] args) throws Exception {
        N = read();
        M = read();
        
        map = new byte[N][M + 1];
        visited = new boolean[2][N][M];

        for (int i = 0; i < N; i++) {
            System.in.read(map[i]);
        }
        
        System.out.print(bfs());
    }
    
    private static int read() throws Exception {
    	int c, n = System.in.read() & 15;
    	
    	while ((c = System.in.read()) > 32) {
    		n = (n << 3) + (n << 1) + (c & 15);
    	}
    	
    	return n;
    }

    private static int bfs() {
        Point[] queue = new Point[N * M * 2];
        int head = 0;
        int tail = -1;
        
        queue[++tail] = new Point(0, 0, 1, 0);
        visited[0][0][0] = true;

        while (tail > head - 1) {
            Point curr = queue[head++];

            if (curr.r == N - 1 && curr.c == M - 1) {
                return curr.step;
            }

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M || (map[nr][nc] == 49 && curr.isCrushed == 1)) {
                	continue;
                }

                int isCrushed = curr.isCrushed;

                if (map[nr][nc] == 49 && curr.isCrushed == 0) {
                    isCrushed = 1;
                }
                
                if (visited[isCrushed][nr][nc]) {
                    continue;
                }
                
                queue[++tail] = new Point(nr, nc, curr.step + 1, isCrushed);
                visited[isCrushed][nr][nc] = true;
            }
        }
        
        return -1;
    }
}

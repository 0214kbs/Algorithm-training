class Main {

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private static byte[][] map;
    private static int R, C, N;

    public static void main(String[] args) throws Exception {
        R = read();
        C = read();
        N = read();
        map = new byte[R][C + 1];

        for (int i = 0; i < R; i++) {
            System.in.read(map[i]);
        }

        int th = N % 4;

        if (th == 0 || th == 2) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    map[i][j] = 79;
                }
            }

        } else if (N != 1 && (th == 1 || th == 3)) {
            change();

            if (th == 1) {
                change();
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append((char)map[i][j]);
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }

    private static void change() {
        for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 79) {
					bomb(i, j);
				}
			}
		}

        for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 66) {
					map[i][j] = 46;
					
				} else if (map[i][j] == 46) {
					map[i][j] = 79;
				}
			}
		}
    }

    private static void bomb(int r, int c) {
		map[r][c] = 66;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == 79) {
                continue;
            }
			
			map[nr][nc] = 66;
		}
	}
}

class Main {

    private static int[][] map  = new int[10][10];
    private static int[] confetti = {0, 5, 5, 5, 5, 5};
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                map[i][j] = read();
            }
        }

        dfs(0, 0, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }

    private static void dfs(int r, int c, int count) {
        if (r >= 9 && c > 9) {
            if (count < min) {
                min = count;
            }

            return;
        }

        if (count >= min) {
            return;
        }

        if (c > 9) {
            dfs(r + 1, 0, count);
            return;
        }

        if (map[r][c] == 1) {
            for (int i = 5; i >= 1; i--) {
                if (confetti[i] > 0 && isAttach(r, c, i)) {
                    attach(r, c, i, 0);
                    confetti[i]--;
                    dfs(r, c + 1, count + 1);
                    attach(r, c, i, 1);
                    confetti[i]++;
                }
            }
        } else {
            dfs(r, c + 1, count);
        }
    }

    private static boolean isAttach(int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (i < 0 || i >= 10 || j < 0 || j >= 10 || map[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void attach(int r, int c, int size, int state) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                map[i][j] = state;
            }
        }
    }
}

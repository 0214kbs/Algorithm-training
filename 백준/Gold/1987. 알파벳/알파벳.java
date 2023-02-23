import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;
    static int R, C;
    static int dx[] = { 1, -1, 0, 0 };
    static int dy[] = { 0, 0, 1, -1 };
    
    static boolean[] visit = new boolean[26];
    static Set<Integer> hs = new HashSet<>();
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j) - 'A';
            }
        }

        find(0, 0, max);
        System.out.println(max);
    }

    static void find(int y, int x, int cnt) {
        if (visit[board[y][x]]) {
            max = Math.max(max, cnt);
        } else {
            visit[board[y][x]] = true;
            for (int d = 0; d < 4; d++) {
            	int ny = y + dy[d];
                int nx = x + dx[d];
                if (nx >= 0 && ny >= 0 && ny < R && nx < C) {
                	find(ny, nx, cnt + 1);
                }
            }
            visit[board[y][x]] = false;
        }

    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C, ans = Integer.MAX_VALUE;
    static char map[][];
    
    static Queue<Point> Water = new ArrayDeque<>();
    static Queue<Point> Dochi = new ArrayDeque<>();
    static boolean[][] visited;
    
    static Point D;
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][];
        
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        visited = new boolean[R][C];

        // 기본 세팅해주기 : D, water, dochi 
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if( map[i][j] == '*') {
                    Water.add(new Point( i, j, 0));
                }else if( map[i][j] == 'S') {
                    Dochi.add(new Point( i, j, 0));
                    visited[i][j] = true;
                }else if( map[i][j] == 'D') {
                    D = new Point( i, j, 0); 
                }
            }
        }
        
    }
    
    static void solve() {
        while( !Dochi.isEmpty() ) {
            
            // 물 흐르기
            int w_size = Water.size();
            for (int i = 0; i < w_size; i++) {
                Point w = Water.poll();
                
                for (int d = 0; d < 4; d++) {
                    int ny = w.y + dy[d];
                    int nx = w.x + dx[d];
                    
                    if( 0 <= nx && nx < C && 0 <= ny && ny < R && map[ny][nx] == '.' ) {
                        map[ny][nx] = '*';
                        Water.add(new Point(ny, nx, w.t + 1) );
                    }
                }
            }
            
            // 고슴도치 이동하기
            int dochi_size = Dochi.size();
            for (int i = 0; i < dochi_size; i++) {
                Point dochi = Dochi.poll();
                
                // 고슴도치가 목적지에 도달했을 때
                if( dochi.y == D.y && dochi.x == D.x ) {
                    System.out.println ( dochi.t );
                    return;
                }
                
                for (int d = 0; d < 4; d++) {
                    int ny = dochi.y + dy[d];
                    int nx = dochi.x + dx[d];
                    
                    if( 0 <= nx && nx < C && 0 <= ny && ny < R && (map[ny][nx] == '.' || map[ny][nx] == 'D') && !visited[ny][nx]) {
                        Dochi.add(new Point(ny, nx, dochi.t + 1));
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        // 여기까지 나오면 탈출하지 못한 것
        System.out.println("KAKTUS");
    }
    
    static class Point{
        int y, x, t;

        public Point(int y, int x, int t) {
            this.y = y;
            this.x = x;
            this.t = t;
        }
    }
    
    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
    

    
    static void print() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
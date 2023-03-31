import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans;
	static char[][] map;
	static boolean[][][] visit;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = {  0, 0,-1, 1 };
	// bfs
	static Queue<Node> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    map = new char[N][M];
	    visit = new boolean[N][M][1 << 6];
	    
	    for (int i = 0; i < N; i++) {
	        String str = br.readLine();
	        for (int j = 0; j < M; j++) {
	            char ch = str.charAt(j);
	            map[i][j] = ch;
	            if( ch == '0' ) {
	                visit[i][j][0] = true;
	                queue.offer(new Node(i, j, 0, 0 ));
	            }
	        }
	    }
	    
	    // 풀이
	    bfs();
	    
	    System.out.println(ans);
	}

	static void bfs() {
	    while( !queue.isEmpty() ) {
	        Node node = queue.poll();
	        
	        // 도착지
	        if( map[node.y][node.x] == '1' ) {
	            ans = node.d;
	            return;
	        }
	        
	        // 사방 탐색
	        for (int d = 0; d < 4; d++) {
	            int ny = node.y + dy[d];
	            int nx = node.x + dx[d];
	            
	            int key = node.key;
	            
	            // range check, 벽돌
	            if( ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == '#' ) continue;
	            
	            // key - 획득 경우
	            if( 'a' <= map[ny][nx] && map[ny][nx] <= 'f' ) {
	                key |= ( 1 << ( map[ny][nx] - 'a' ) );
	            }
	            
	            // key - 사용해야 하는 경우
	            if( 'A' <= map[ny][nx] && map[ny][nx] <= 'F' ) {
	                if( (key & (1 << ( map[ny][nx] - 'A' ))) == 0 ) continue;
	            }
	            
	            // visit
	            if( visit[ny][nx][key] ) continue;
	            
	            visit[ny][nx][key] = true;
	            queue.offer(new Node(ny, nx, key, node.d + 1));
	        }
	    }
	    
	    // 1에 도착하지 못하는 경우
	    ans = -1;
	}

	static class Node{
	    int y, x, key, d;
	    
	    Node( int y, int x, int key, int d ){
	        this.y = y;
	        this.x = x;
	        this.key = key;
	        this.d = d;
	    }
	}
}

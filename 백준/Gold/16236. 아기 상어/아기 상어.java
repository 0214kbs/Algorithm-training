import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, sy, sx, sSize, sEatCnt, ans;

	static int[][] map;
	static boolean[][] visit;

	static Queue<Node> queue = new ArrayDeque<>();
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = {  0, 0,-1, 1 };

	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    map = new int[N][N];
	    visit = new boolean[N][N];
	    
	    for (int i = 0; i < N; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        for (int j = 0; j < N; j++) {
	            int n = Integer.parseInt(st.nextToken());
	            if( n == 9 ) {
	                sy = i;
	                sx = j;
	            }
	            map[i][j] = n;
	        }
	    }
	    
	    // 최초 상어의 크기
	    sSize = 2;
	    
	    // 시물레이션
	    while(true) {
	        int cnt = bfs(); // 가장 가까운 먹을 수 있는 거리
	        if( cnt == 0 ) break; // 더 이상 먹을 수 없는 상황
	        ans += cnt; // 누적 거리 (시간)
	    }

	    System.out.println(ans);
	}

	// 현재 탐색에서 가장 가까운 물고기 거리 리턴 없으면 0
	static int bfs() {
	    // 먹이 후보
	    int minY = Integer.MAX_VALUE;
	    int minX = Integer.MAX_VALUE;
	    int minDis = Integer.MAX_VALUE;
	    
	    // visit 초기화
	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < N; j++) {
	            visit[i][j] = false;
	        }
	    }
	    
	    // 시작을 위한 Node 한개 queue 에 넣고 시작
	    visit[sy][sx] = true;
	    queue.offer(new Node(sy, sx, 0));
	    
	    while( !queue.isEmpty() ) {
	        // 한 개 꺼낸다.
	        Node node = queue.poll();
	        // 먹을 수 있는 지 따진다.
	        if( map[node.y][node.x] != 0 && map[node.y][node.x] < sSize ) {
	            
	            // 가장 가까운지 따진다.
	            if( node.d < minDis ) { // 거리로 판명
	                minDis = node.d;
	                minY = node.y;
	                minX = node.x;
	            }else if( node.d == minDis ) { // 거리가 같으면 y 작은 순 y 같으면 x 작은 순
	                if( node.y < minY ) {
	                    minDis = node.d;
	                    minY = node.y;
	                    minX = node.x;
	                }else if( node.y == minY ) {
	                    if( node.x < minX ) {
	                        minDis = node.d;
	                        minY = node.y;
	                        minX = node.x;
	                    }
	                }
	            }
	        }
	        
	        for (int d = 0; d < 4; d++) {
	            int ny = node.y + dy[d];
	            int nx = node.x + dx[d];
	            // 범위, visit, 상어보다 크면 skip
	            if( ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] || map[ny][nx] > sSize ) continue;
	            
	            visit[ny][nx] = true;
	            queue.offer(new Node(ny, nx, node.d + 1)); // 거낸 Node 의 거리 + 1
	        }
	    }
	    
	    // 탐색이 끝나면 시물레이션 규칙에 맞게 정리, 계산
	    if( minDis == Integer.MAX_VALUE ) return 0; // 물고기를 못 찾는 경우
	    else {
	        sEatCnt++; // 먹은 수 증가
	        if( sEatCnt == sSize ) { // 먹은 수가 상어의 크기와 같으면
	            sSize++;
	            sEatCnt = 0;
	        }
	        
	        // map 정리
	        map[minY][minX] = 0; // 먹은 물고기 자리 => 빈칸
	        map[sy][sx] = 0; // 상어 출발 자리 => 빈칸
	        
	        // 새로운 상어의 위치 보정
	        sy = minY;
	        sx = minX;
	    }
	    
	    return minDis;
	}

	static class Node{
	    int y, x, d;
	    
	    Node(int y, int x, int d){
	        this.y = y;
	        this.x = x;
	        this.d = d;
	    }
	}
}
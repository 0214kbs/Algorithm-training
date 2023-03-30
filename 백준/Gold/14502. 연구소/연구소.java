import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, max;
	static int[][] map, virusMap;
	static boolean[][] visit;
	static List<int[]> zero = new ArrayList<>(); // 벽을 세우는 조합의 src 해당
	static List<int[]> virus = new ArrayList<>();
	static int zeroSize;
	static int[][] wall = new int[3][2]; // 벽이 세워지는 tgt 해당

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = {  0, 0,-1, 1 };

	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    map = new int[N][M];
	    max = Integer.MIN_VALUE;
	    
	    for (int i = 0; i < N; i++) {
	        st = new StringTokenizer(br.readLine());
	        for (int j = 0; j < M; j++) {
	            int n = Integer.parseInt(st.nextToken());
	            map[i][j] = n;
	            
	            if( n == 0 ) zero.add(new int[] {i, j});
	            else if( n == 2 ) virus.add(new int[] {i, j});
	        }
	    }
	    
	    zeroSize = zero.size();
	    
	    // 벽 3개를 조합으로 처리
	    comb( 0, 0 );
	    
	    System.out.println(max);
	}

	static void comb(int srcIdx, int tgtIdx) {
	    // 기저조건
	    if( tgtIdx == 3 ) {
	        // complete code
	        // 벽을 다 세운 상태
	        virus();
	        return;
	    }
	    
	    if( srcIdx == zeroSize ) return;
	    
	    wall[tgtIdx] = zero.get(srcIdx);
	    
	    comb(srcIdx + 1, tgtIdx + 1);// 현재 srcIdx 선택
	    comb(srcIdx + 1, tgtIdx);// 현재 srcIdx 선택 X 같은 tgtIdx 에 다음 srcIdx 를  고려
	    
	}


	static void virus() {
	    // virus 확산
	    // 안전지대 계산
	    
	    virusMap = new int[N][M];
	    visit = new boolean[N][M];
	    
	    // map copy
	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < M; j++) {
	            virusMap[i][j] = map[i][j];
	        }
	    }
	    
	    // virusMap 에 벽을 세운다
	    for (int i = 0; i < 3; i++) {
	        virusMap[ wall[i][0] ][ wall[i][1] ] = 1;
	    }
	    
	    // virus 확산
	    for (int[] v : virus) {
	        dfs( v[0], v[1] );
	    }
	    
	    // 안전 지대 계산 max 갱신
	    int sum = 0;
	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < M; j++) {
	            if( virusMap[i][j] == 0 ) sum++;
	        }
	    }
	    
	    max = Math.max(max, sum);
	}

	static void dfs( int y, int x ) {
	    for (int d = 0; d < 4; d++) {    
	        int ny = y + dy[d];
	        int nx = x + dx[d];
	        if( ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] ) continue;
	        if( virusMap[ny][nx] == 0 ) {
	            virusMap[ny][nx] = 2;
	            visit[ny][nx] = true;
	            dfs( ny, nx);
	        }
	    }
	}
}

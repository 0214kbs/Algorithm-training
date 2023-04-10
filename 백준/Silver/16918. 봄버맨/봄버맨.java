import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//시물레이션
//0초 : 초기 폭탄 설치
//1초 : 아무것도 안함.
//2초 : 빈 곳에 폭탄 설치 -> 전체 맵에 폭탄 설치 ( 전부 'O' )
//3초 : 폭탄 폭발 ( 0초( 현재보다 3초 이전 ) 설치된 폭탄 폭발 + 2초에 설치한 폭탄 중 0초 설치된 폭탄 주변 함께 제거 )
//4초 : 빈 곳에 폭탄 설치 -> 전체 맵에 폭탄 설치 ( 전부 'O' )
//5초 : 폭탄 폭발 ( 2초( 현재보다 3초 이전 ) 설치된 폭탄 폭발 + 4초에 설치한 폭탄 중 2초 설치된 폭탄 주변 함께 제거 )
//6초 : 빈 곳에 폭탄 설치 -> 전체 맵에 폭탄 설치 ( 전부 'O' )
//7초 : 폭탄 폭발 ( 4초( 현재보다 3초 이전 ) 설치된 폭탄 폭발 + 6초에 설치한 폭탄 중 4초 설치된 폭탄 주변 함께 제거 )
//N = 1 : 초기 맵
//N = 2 : 전체 맵에 'O'
//N = 3, 4, 5, 6, 7 까지만 따지고 그 이후의 N 에 값에 대해서 4 이후 반복이므로 4의 배수를 제하고 처리

//0 - 1 -     -5      -9 ...
//    2 -  4  -6  -8
//      3 -     -7
public class Main {
	static int R, C, N;
	static int[][] map; // char => int map에 몇 초뒤...
	static int EMPTY = -9; // '.' 대신 int 사용
	static StringBuilder sb = new StringBuilder(); // 출력이 크다.

	// 상하좌우 delta
	static int[] dy = {-1, 1, 0, 0 };
	static int[] dx = { 0, 0,-1, 1 };


	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    R = Integer.parseInt(st.nextToken());
	    C = Integer.parseInt(st.nextToken());
	    N = Integer.parseInt(st.nextToken());
	    
	    map = new int[R][C];
	    
	    // 0초 폭탄 설치
	    for (int i = 0; i < R; i++) {
	        char[] temp = br.readLine().toCharArray();
	        for (int j = 0; j < C; j++) {
	            map[i][j] = temp[j] == '.' ? EMPTY : 0;
	        }
	    }
	            
	    // N 값에 따라 다르게 처리
	    if( N == 1 ){ // 초기 폭탄 맵 그대로
	    
	        for (int i = 0; i < R; i++) {        
	            for (int j = 0; j < C; j++) {
	                sb.append(map[i][j] == EMPTY ? '.' : 'O');
	            }
	            sb.append("\n");
	        }
	        
	    }else if( N % 2 == 0 ){ // 짝수
	        for (int i = 0; i < R; i++) {        
	            for (int j = 0; j < C; j++) {
	                sb.append('O');
	            }
	            sb.append("\n");
	        }    
	        
	        // 맵에 대한 작업 X    
	    }else{
	        // N의 반복을 이용해서 4배수만큼 줄인다. 
	        N = N % 4 + 4;
	        
	        for (int t = 2; t <= N; t++) { // N 이 2 일 때 맵에 대한 작업 수행 X,  2부터 시물레이션 진행 필요
	            // 짝수 초 : 폭탄 설치, 홀수 초 : 폭판 폭발
	            if( t % 2 == 0 ) putBomb(t);
	            else explodeBomb(t);
	        }
	        
	        for (int i = 0; i < R; i++) {        
	            for (int j = 0; j < C; j++) {
	                sb.append(map[i][j] == EMPTY ? '.' : 'O');
	            }
	            sb.append("\n");
	        }            
	    }
	    
	    System.out.println(sb);
	}

	static void putBomb(int time){
	    for (int i = 0; i < R; i++) {        
	        for (int j = 0; j < C; j++) {
	            if(map[i][j] == EMPTY ) map[i][j] = time; // 시간 기록
	        }
	    }
	}

	static void explodeBomb(int time){
	    for (int i = 0; i < R; i++) {        
	        for (int j = 0; j < C; j++) {
	            // 설치된 지 3초가 지난 폭탄
	            int now = time - 3;
	            
	            if( map[i][j] != now ) continue;
	            
	            // 3초 지난 폭탄 폭발
	            map[i][j] = EMPTY;
	            
	            // 폭발된 폭탄 주변 폭탄도 같이 폭발
	            for (int d = 0; d < 4; d++) {
	                int ny = i + dy[d];
	                int nx = j + dx[d];
	                
	                if( ny < 0 || nx < 0 || ny >= R || nx >= C ) continue;
	                
	                // != EMPTY 를 폭발시키면 안된다. != now 를 폭발시켜야 함
	                if( map[ny][nx] != now ) map[ny][nx] = EMPTY;  
	            }
	        }
	    }        
	}
}

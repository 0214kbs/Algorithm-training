
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	static int[] dx = new int[] {0,0,-1,1};
	static int[] dy = new int[] {1,-1,0,0};
	
	static int[][] board;
	static boolean[][] visited;
	
	static int n, cnt;
    
	public static void main(String[] args) throws Exception {
    	// setting
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 단지 별 집 수 
        int total = 0; // 총 단지수
        
        n = Integer.parseInt(br.readLine());
       
        board = new int[n][n];
        visited = new boolean[n][n];
        
        for(int i=0;i<n;i++) {
        	String str = br.readLine();
        	for(int j=0;j<n;j++) {
        		board[i][j] = Integer.parseInt(str.split("")[j]);
        	}
        }

        // sol
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		cnt = 0;
        		if(board[i][j] == 1 && !visited[i][j]) {
        			total++;
        			cnt++;
        			dfs(i,j);
        			pq.add(cnt);
        		}
        	}
        }
        
        // output
        System.out.println(total);
        for(int i=0;i<total;i++) {
        	System.out.println(pq.poll());
        }
    }
    
    static void dfs(int cy, int cx) {
    	visited[cy][cx] = true;
    	
    	int nx,ny;
    	for(int d=0;d<4;d++) {
    		nx = dx[d]+cx;
    		ny = dy[d]+cy;
    		
    		if(ny>=0 && ny<n && nx>=0 && nx<n) {
    			if(!visited[ny][nx] && board[ny][nx] == 1) {
    				cnt++;
    				dfs(ny,nx);
    			}
    		}
    	}
    	
    }
}
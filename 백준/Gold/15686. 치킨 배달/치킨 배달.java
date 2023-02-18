import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static List<Pair> chickenPos = new ArrayList<>();
    static List<Pair> homePos = new ArrayList<>();
    static boolean[] realChick; // 나중에 총 chickenPos 사이즈로 초기화 
    static int res = Integer.MAX_VALUE;
    
	static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// setting
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int[][] board = new int[N][N];
        
        
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        		if(board[i][j] == 2) chickenPos.add(new Pair(i,j));
        		if(board[i][j] == 1) homePos.add(new Pair(i,j));
        	}
        }
        
        realChick = new boolean[chickenPos.size()];
        dfs(0,0);
        System.out.println(res);
        
	}
	
	static void dfs(int start, int cnt) {
		if (cnt == M) { // 모든 집에 대해 M개의 치킨집 중에 최단거리 계산
            int minDsum = 0;
 
            for (int i = 0; i < homePos.size(); i++) {
                int minDist = Integer.MAX_VALUE;
 
                for (int j = 0; j < chickenPos.size(); j++) {
                    if (realChick[j]) {
                        int dist = Math.abs(homePos.get(i).x - chickenPos.get(j).x) + Math.abs(homePos.get(i).y - chickenPos.get(j).y);
                        minDist = Math.min(minDist, dist);
                    }
                }
                minDsum += minDist;
            }
            res = Math.min(res, minDsum);
            return;
        }
 
        for (int i = start; i < chickenPos.size(); i++) {
        	realChick[i] = true;
            dfs(i + 1, cnt + 1);
            realChick[i] = false;
        }
    }
	
}
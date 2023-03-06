import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static class Pair{
		int r,c;

		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	static int N,coreCntMax,lenMin;
	static int[][] map;
	static List<Pair> core;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
	    for (int t = 1; t <= T; t++) {
	    	sb.append("#"+t+" ");
	    	// 초기화
	    	core = new ArrayList<>();
	    	coreCntMax = 0;
	    	lenMin = Integer.MAX_VALUE;
	    	
	    	N = Integer.parseInt(br.readLine());
	    	map = new int[N][N];
	    	
	        for(int i=0;i<N;i++) {
	        	StringTokenizer st = new StringTokenizer(br.readLine());
	        	for(int j=0;j<N;j++) {
	        		map[i][j] = Integer.parseInt(st.nextToken());
	        		if(map[i][j] == 1) {
	        			if(i>0 &&  i<N-1 && j>0 &&  j<N-1) core.add(new Pair(i,j));
	        		}
	        	}
	        }
	        
	        func(0,0,0);
	        sb.append(lenMin+"\n");
	    }
	    System.out.println(sb);
		
	}
	

	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static void func(int coreIdx, int coreCnt, int totalLen) {
		if(coreIdx == core.size()) {
			if(coreCntMax<coreCnt) {
				coreCntMax = coreCnt;
				lenMin = totalLen;
			}
			else if(coreCntMax == coreCnt) lenMin = Math.min(totalLen, lenMin);
			
			return;
		}
		
		Pair p = core.get(coreIdx);
		for(int d=0;d<4;d++) {
			int nr = p.r;
			int nc = p.c;
			int cnt = 0;
			
			while(true) {
				nr += dr[d];
				nc += dc[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N) break;
				if(map[nr][nc]==1) {
					cnt = 0;
					break;
				}
				cnt++;
			}
			
			for(int i=1;i<=cnt;i++) {
				map[p.r+dr[d]*i][p.c+dc[d]*i] = 1;
			}
			if(cnt == 0) func(coreIdx+1, coreCnt, totalLen);
			else {
				func(coreIdx+1, coreCnt+1, cnt+totalLen);
				for(int i=1;i<=cnt;i++) {
					map[p.r+dr[d]*i][p.c+dc[d]*i] = 0;
				}
				
			}
		}
		
	}
}

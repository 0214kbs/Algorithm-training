import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static boolean[] visit;
	static int N;
	public static void main(String[] args)throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N =Integer.parseInt(br.readLine());
		board = new int[N+1][N+1];
		visit = new boolean[N+1]; 
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(1,0);
		System.out.println(min);
		
	}
	
	static int min=Integer.MAX_VALUE;
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == N/2) {
			min = Math.min(cal(), min);
			return;
		}
		for(int i=srcIdx;i<=N;i++) {
			if(!visit[i]) {
				visit[i] = true;
				comb(i+1, tgtIdx+1);
				visit[i] = false;
			}
		}
	}
	
	static int cal() {
//		List<Integer> teamS = new ArrayList<>();
//		List<Integer> teamL = new ArrayList<>();
//		for(int i=1;i<=N;i++) {
//			if(visit[i]) teamS.add(i);
//			else teamL.add(i);
//		}
		int sumS = 0;
		int sumL = 0;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(visit[i]&& visit[j]) sumS+= board[i][j];
				else if(!visit[i]&& !visit[j])sumL+= board[i][j];
			}
		}
		return Math.abs(sumS-sumL);
	}
}

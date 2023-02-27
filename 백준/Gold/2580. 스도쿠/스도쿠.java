import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static class Pair{
		int y, x;

		public Pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	static int[][] board;
	static List<Pair> zero;
	static boolean complete = false;  // 중간에 마무리 지으면 true로 놓고 각 dfs에서 확인 flag
	
	public static void main(String[] args)throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		zero = new ArrayList<Pair>();
		board = new int[9][9];
		
		for(int i=0;i<9;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				int n = Integer.parseInt(st.nextToken());
				board[i][j] = n;
				if(n == 0) zero.add(new Pair(i,j));
			}
		}

		dfs(0); 
	}

	static void dfs(int idx) {
		
		// 기저조건
		if(complete) return;
		if(idx==zero.size()) {
			complete = true;
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(board[i][j]+" ");
				}
				System.out.println();
			}
			return;
		}

		int y = zero.get(idx).y;
		int x = zero.get(idx).x;
		
		boolean[] nums = new boolean[10]; 
		
		// 가로
		for(int i=0;i<9;i++) {
			if(board[y][i] !=0 ) nums[board[y][i]] = true;
		}
		// 세로
		for(int i=0;i<9;i++) {
			if(board[i][x] !=0 ) nums[board[i][x]] = true;
		}
		
		
		// 3X3
		int ny = (y/3)*3;
		int nx = (x/3)*3;
		for(int i=ny; i<ny+3;i++) {
			for(int j=nx; j<nx+3;j++) {
				if(board[i][j] !=0 ) nums[board[i][j]] = true;
			}
		}
		int cnt =0;
		for(int i=1;i<=9;i++) {
			cnt++;
		}
		for(int i=1 ;i<=9;i++) {
			if(!nums[i]) {
				board[y][x] = i;
				dfs(idx+1);
				if(cnt>1)board[y][x] = 0;
			}
		}
	}
	
	
}	
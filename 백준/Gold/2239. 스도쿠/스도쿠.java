import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] board = new int[10][10];
    static List<Pair> zero = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean flag;

    static class Pair {
        int r, c;
        
        public Pair() { }

		public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
    	for (int i = 1; i < 10; i++) {
            String str = br.readLine();
            for (int j = 1; j < 10; j++) {
                
            	board[i][j] = str.charAt(j-1)-'0';
                if(board[i][j] == 0) zero.add(new Pair(i, j));
            }
        }
        dfs(0);
        System.out.println(sb);
    }


    public static void dfs(int idx) {
    	
        if (idx == zero.size()) {
            flag = true;
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 10 ; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
            sb.append("\n");
            return;
        }
        if(flag) return;
        
        Pair p = zero.get(idx);
        for (int j = 1; j < 10; j++) {
            if (board[p.r][p.c] == 0 && check(p.r, p.c, j)) {
                board[p.r][p.c] = j;
                dfs(idx + 1);
                board[p.r][p.c] = 0;
            }

        }
    }


    static boolean check(int r, int c, int val) {
        for (int i = 1; i < 10; i++) {
            if (c != i && board[r][i] == val)
                return false;
            if (r != i && board[i][c] == val)
                return false;
        }
        int rRange, cRange;
        if (r % 3 == 0) rRange = r - 2;
        else rRange = r - r % 3 + 1;
        if (c % 3 == 0) cRange = c - 2;
        else cRange = c - c % 3 + 1;

        for (int i = rRange; i < rRange + 3; i++) {
            for (int j = cRange; j < cRange + 3; j++) {
                if (r != i && c != j && board[i][j] == val) return false;
            }
        }
        return true;
    }

}
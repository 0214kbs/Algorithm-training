class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int[][][] dp = new int[3][N + 1][N + 1];

        int i = 0;
        int[] prev = dp[i][0];
        int[] curr = dp[i ^ 1][0];

        dp[0][1][2] = 1;
        
        for (int r = 1; r <= N; r++) {
            curr[1] = read();
            curr[2] = read();
            
            for (int c = 3; c <= N; c++) {
                curr[c] = read();
                
                if (curr[c] == 1) {
                	continue;
                }
                
                dp[0][r][c] = dp[0][r][c - 1] + dp[2][r][c - 1];
                dp[1][r][c] = dp[1][r - 1][c] + dp[2][r - 1][c];
                
                if (prev[c] + curr[c - 1] > 0) {
                	continue;
                }
                
                dp[2][r][c] = dp[0][r - 1][c - 1] + dp[1][r - 1][c - 1] + dp[2][r - 1][c - 1];
            }
            
            i ^= 1;
            prev = dp[i][0];
            curr = dp[i ^ 1][0];
        }

        System.out.print(dp[0][N][N] + dp[1][N][N] + dp[2][N][N]);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        
        while ((c = System.in.read()) > 32) {
        	n = (n << 3) + (n << 1) + (c & 15);
        }
        
        return n;
    }

}

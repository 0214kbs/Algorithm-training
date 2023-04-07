import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static final int MOD = 1234567891;

    
    public static void main(String[] args) throws Exception {
        BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            long factorial[] = new long[n + 1];
            factorial[0] = 1;
            for (int i = 1; i <= n; i++) {
            	factorial[i] = (factorial[i - 1] * i) % MOD;
            }

            long bottom = (factorial[r] * factorial[n - r]) % MOD;

            sb.append("#"+t+" ");
            sb.append((factorial[n] * pow(bottom, MOD - 2)) % MOD);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static long pow(long n, int x) {
        if (x == 0) return 1;
        long res = pow(n, x / 2);
        long next = (res * res) % MOD;
        if (x % 2 == 0) return next;
        else return (next * n) % MOD;
    }
}
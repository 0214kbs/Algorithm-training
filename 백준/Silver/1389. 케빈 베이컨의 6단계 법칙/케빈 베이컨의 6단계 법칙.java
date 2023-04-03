import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int INF = 987654321;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] friends = new int[N+1][N+1];
		
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				friends[i][j] = INF;
				if(i==j) friends[i][j] = 0;
			}
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			friends[A][B] = 1;
			friends[B][A] = 1;
		}
		
		// 플로이드
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                	friends[i][j] = Math.min(friends[i][j], friends[i][k] + friends[k][j]);
                }
            }
        }
        
        
        int check = INF;
        int num = -1;
        
        for(int i=1;i<=N;i++) {
        	int sum = 0;
        	for(int j=1;j<=N;j++) {
        		sum+= friends[i][j];
        	}
        	
        	if(check>sum) {
        		check = sum;
        		num = i;
        	}
        }
        System.out.println(num+"\n");
	}
}
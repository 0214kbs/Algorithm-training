import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static final int INF = 9999999;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[][] adjMatrix = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					int tmp = Integer.parseInt(st.nextToken());
					if(i != j && tmp==0) adjMatrix[i][j]=INF;
					else adjMatrix[i][j] = tmp;
				}
			}
			
			for(int k=0; k<n; ++k) {
				for(int i=0; i<n; ++i) {
					if(i==k) continue;
					for(int j=0; j<n; ++j) {
						if(i==j || k==j) continue;
						adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k]+adjMatrix[k][j]);
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			for(int i=0;i<n;i++) {
				int sum = 0;
				for(int j=0;j<n;j++) {
					sum+= adjMatrix[i][j];
				}
				min = Math.min(min, sum);
			}
			
			System.out.println("#"+t+" "+min);
		}
		
	}
}

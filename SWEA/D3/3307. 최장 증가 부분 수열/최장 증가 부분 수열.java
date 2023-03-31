import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] lis = new int[N];
			int max = 1;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<N;i++) {
				lis[i] = 1;
				for(int j=0;j<i;j++) {
					if(arr[i]>arr[j] && lis[i]<=lis[j]) {
						lis[i] = lis[j]+1;
						max = Math.max(max, lis[i]);
					}
				}
			}
			sb.append("#"+t+" "+max).append("\n");
		}
		System.out.println(sb);
	}
}

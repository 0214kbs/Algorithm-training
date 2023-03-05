import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			sb.append("#"+t+" ");
			int N = Integer.parseInt(br.readLine());
			int[] trees = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int maxT = 0;
			for(int i=0;i<N;i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				maxT = Math.max(maxT, trees[i]);
			}
			
			int res = 0, even = 0, odd = 0;
			for(int i=0;i<N;i++) {
				int tmp = maxT-trees[i];
				if(tmp == 0) continue; //기준 tree
				even += tmp/2;
				odd += tmp%2;
			}
			
			if(even>odd) { // 2->1
				while(Math.abs(even-odd)>1) {
					even--;
					odd+=2;
				}
			}
			
			if(odd>even) res = odd*2-1;
			else if(odd<even) res= even*2;
			else res = odd+even;
			
			sb.append(res+"\n");
		}
		System.out.println(sb);
	}
}
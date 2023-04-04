import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static int n,m,sum;
	static ArrayList<Integer> arr[];
	static int num[];
	static boolean visit[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());
			
			num = new int[n+1];
			arr= new ArrayList[n+1];
			
			for(int i=0;i<=n;i++) {
				arr[i]=new ArrayList<Integer>();
			}
			
			for (int i = 0; i < m; i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				arr[a].add(b);
			}
			
			for(int i=1;i<=n;i++) {
				sum=0;
				visit=new boolean[n+1];
				visit[i]=true;
				dfs(i);
				num[i]+=sum;
			}
			
			int res=0;
			for(int i=1;i<=n;i++) {
				if(num[i]==n) res++;
			}
			sb.append("#"+t+" "+res+"\n");
		}
		System.out.println(sb);
	}

	static void dfs(int k) {
		sum++;
		for(int i=0;i<arr[k].size();i++) {
			if(visit[arr[k].get(i)]) continue;
			
			visit[arr[k].get(i)]=true;
			num[arr[k].get(i)]++;
			dfs(arr[k].get(i));
		}
	}
}
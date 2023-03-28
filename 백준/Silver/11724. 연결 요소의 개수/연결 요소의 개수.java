import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static List<Integer>[] arr;
    static boolean[] visit;
    static int res;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		visit = new boolean[N+1];
		arr = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		
		res = 0;
		for(int i=1;i<arr.length;i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(i);
				res++;
			}
		}
		System.out.println(res);
		
	}
	
	static void dfs(int cur) {
		if(!visit[cur]) return;

		for(Integer i : arr[cur]) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(i);
			}
		}
	}
}
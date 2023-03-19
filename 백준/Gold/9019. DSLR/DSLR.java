import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int[] DSLR = new int[4];
	static boolean[] visited = new boolean[10000];
	static StringBuilder sb = new StringBuilder();
	static class Pair{
		int a;
		String s;
		public Pair(int a, String s) {
			this.a = a;
			this.s = s;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			DSLR = new int[4];
			visited = new boolean[10000];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			check(A,B);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void calDSLR(int n) {
		DSLR[0] = (n*2)%10000;
		DSLR[1] = (n!=0) ? n - 1 : 9999;
		DSLR[2] = (n % 1000) * 10 + n/1000;
		DSLR[3] = (n % 10) * 1000 + n/10;
	}
	
	static void check(int A, int B) {
		Deque<Pair> q = new ArrayDeque<>();

		q.add(new Pair(A,""));
		visited[A] = true;
		
		while(!q.isEmpty()) {
			Pair p = q.pollFirst();
			calDSLR(p.a);
			
			if(p.a==B) {
				sb.append(p.s);
				return;
			}
			if(!visited[DSLR[0]]) {
				visited[DSLR[0]] = true;
				q.add(new Pair(DSLR[0],p.s+"D"));
			}
			if(!visited[DSLR[1]]) {
				visited[DSLR[1]] = true;
				q.add(new Pair(DSLR[1],p.s+"S"));
			}
			if(!visited[DSLR[2]]) {
				visited[DSLR[2]] = true;
				q.add(new Pair(DSLR[2],p.s+"L"));
			}
			if(!visited[DSLR[3]]) {
				visited[DSLR[3]] = true;
				q.add(new Pair(DSLR[3],p.s+"R"));
			}
		}
		
	}
}
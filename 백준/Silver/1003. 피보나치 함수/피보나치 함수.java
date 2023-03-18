import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static class Pair{
		int zero;
		int one;
		public Pair(int zero, int one) {
			this.zero = zero;
			this.one = one;
		}
	}

	static List<Pair> arr = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		arr.add(new Pair(1,0));
		arr.add(new Pair(0,1));
		for(int t=0;t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			if(n>=arr.size()) check(n);
			sb.append(arr.get(n).zero+" "+arr.get(n).one+"\n");
		}
		System.out.println(sb);
	}
	
	
	static void check(int n) {
		int cur=arr.size()-1;
		while(true) {
			if(cur==n) break;
			arr.add(new Pair(arr.get(cur-1).zero+arr.get(cur).zero,arr.get(cur).one+arr.get(cur-1).one));
			cur+=1;
			
		}
	}
	
}
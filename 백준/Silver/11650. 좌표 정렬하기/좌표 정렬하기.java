import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Pair[] arr = new Pair[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new Pair(x,y);
		}
		
		Arrays.sort(arr, new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				if(p1.x == p2.x) return p1.y-p2.y;
				else return p1.x-p2.x;	
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(arr[i].x);
			sb.append(" ");
			sb.append(arr[i].y);
			sb.append("\n");
		}		
		System.out.println(sb);
	}
	
	static class Pair{
		int x, y;
		public Pair() {}
		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
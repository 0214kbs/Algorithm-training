import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] originX = new int[N];
		int[] sortX = new int[N];
		Map<Integer,Integer> hm = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int a = Integer.parseInt(st.nextToken());
			originX[i]=sortX[i] = a;
		}
		Arrays.sort(sortX);
		
		int cnt = 0;
		for(int x: sortX) {
			if(!hm.containsKey(x)) {
				hm.put(x, cnt);
				cnt++;
			}
		}
		
		// output
		StringBuilder sb = new StringBuilder();
		for(int x : originX) {
			int rank = hm.get(x);
			sb.append(rank).append(" ");
		}
		System.out.println(sb);
	}
}
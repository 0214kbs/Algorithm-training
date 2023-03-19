import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			Map<String,Integer> hm = new HashMap<>();
			int n = Integer.parseInt(br.readLine());
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String type = st.nextToken();
				
				// (없으면 0 있으면 해당값)+1
				hm.put(type, hm.getOrDefault(type, 0)+1);
				
			}
			
			int res = 1;
			for(Integer i: hm.values()) {
				res = res*(i+1);
			}
			sb.append((res-1)+"\n"); // 안 입었을때 
		}
		System.out.println(sb);
	}
}
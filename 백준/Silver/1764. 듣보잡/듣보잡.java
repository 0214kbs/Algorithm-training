import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String,Integer> hm = new HashMap<>();
		for (int i = 0; i < N; i++) {
			hm.put(br.readLine(), 1);
		}
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			hm.put(s, hm.getOrDefault(s, 0)+1);
		}
		
		// output
		StringBuilder sb = new StringBuilder();
		List<String> keys = new ArrayList<>(hm.keySet());
		Collections.sort(keys);
		int cnt = 0;
		for (String key : keys) {
			if(hm.get(key) == 2) {
				cnt++;
				sb.append(key).append("\n");
			}
		}
		System.out.println(cnt);
		System.out.println(sb);
	}
}
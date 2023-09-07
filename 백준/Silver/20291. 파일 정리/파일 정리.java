import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> hm = new HashMap<>();

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			String tmp = str.substring(str.indexOf('.') + 1);
			if (hm.get(tmp) != null)
				hm.put(tmp, hm.get(tmp) + 1);
			else
				hm.put(tmp, 1);
		}
		// sort - TreeMap 이용
		Map<String, Integer> sortedMap = new TreeMap<>(hm);

		// output
		StringBuilder sb = new StringBuilder();
		sortedMap.forEach((key, value) -> {
			sb.append(key + " " + value).append("\n");
		});
		System.out.println(sb);
	}
}

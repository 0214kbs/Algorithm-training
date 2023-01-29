import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// 시간 초과나서 HashMap 으로 변경
		HashMap<String, Integer> nameId = new HashMap<String, Integer>();
		String[] name = new String[n+1];
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<n+1;i++) {
			String s = br.readLine();
			nameId.put(s,i);
			name[i] = s;
		}
		for(int i=0;i<m;i++) {
			String s =br.readLine();
			try {
				sb.append(name[Integer.parseInt(s)]).append("\n");
			}catch(NumberFormatException e) {
				
//				System.out.println(Arrays.asList(name).indexOf(s));
				sb.append(nameId.get(s)).append("\n");
			}
			
		}
		
		System.out.println(sb);
	}
}

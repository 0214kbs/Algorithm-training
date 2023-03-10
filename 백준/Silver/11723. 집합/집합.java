import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st; int cnt,num; String s;
		List<Integer> S = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			cnt = st.countTokens();
			if(cnt == 2) {
				s = st.nextToken();
				num = Integer.parseInt(st.nextToken());
				
				switch (s) {
				case "add":
					if(!S.contains(num)) S.add(num);
					break;
				case "remove":
					if(S.contains(num)) S.remove(S.indexOf(num)); 
					break;
				case "check":
					if(S.contains(num)) sb.append(1+"\n");
					else sb.append(0+"\n");
					break;
				default: // toggle
					if(!S.contains(num)) S.add(num);
					else S.remove(S.indexOf(num));
					break;
				}
				
			}else {
				s = st.nextToken();
				switch (s) {
				case "all":
					S.clear();
					for(int n=1;n<=20;n++) {
						S.add(n);
					}
					break;

				default: //empty
					S.clear();
					break;
				}
				
			}
		}
		System.out.println(sb);
	}
}

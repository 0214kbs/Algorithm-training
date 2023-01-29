import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<String> s = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			s.add(br.readLine());
		}
		int cnt = 0;
		for(int i=0;i<m;i++) {
			String test = br.readLine();
			if(s.contains(test))cnt++;
		}
		
		System.out.println(cnt);
		
	}
}
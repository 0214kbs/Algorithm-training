import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		List<String> list;
		int T = Integer.parseInt(br.readLine());
		boolean res;
		
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			res = true;
			list = new ArrayList<>();
			for(int n=0;n<N;n++) {
				// insert 
				list.add(br.readLine());
			}
			Collections.sort(list);
			for(int i=0;i<N-1;i++) {
				if(list.get(i).length()<list.get(i+1).length()) {
					if(list.get(i).equals(list.get(i+1).substring(0,list.get(i).length()))) res = false;
				}
			}
			
			if(res) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		
		System.out.println(sb);
	}
}
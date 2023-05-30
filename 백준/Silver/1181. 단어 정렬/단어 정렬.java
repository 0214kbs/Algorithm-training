import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashSet<String> set = new HashSet<>();
		
		for(int i=0;i<N;i++) {
			set.add(br.readLine());
		}
		
		List<String> words = new ArrayList<>(set);
		
		Collections.sort(words, (a,b)->{
			if(a.length() == b.length()) return a.compareTo(b);
			else return a.length()-b.length();
		});
		
		
		// output
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<words.size();i++) {
			sb.append(words.get(i));
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		
	}	
	
}
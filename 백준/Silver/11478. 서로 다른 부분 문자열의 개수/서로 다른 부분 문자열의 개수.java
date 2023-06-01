import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		Set<String> set = new HashSet<>();
		
		for(int i=0;i<str.length();i++) {
			for(int j=i;j<str.length()+1;j++) {
//				System.out.println(i+", "+j);
				set.add(str.substring(i, j));
			}
		}
		
		System.out.println(set.size()-1);
	}
}
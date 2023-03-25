import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String[] strArr = str.split("\\-");

		int res = 0;
		
		for(int i=0;i<strArr.length;i++) {
			int calc = 0;
			String[] str2Arr = strArr[i].split("\\+");	
			
			
			for(String s: str2Arr) {
				calc += Integer.parseInt(s);
			}
			
			if(i==0) res += calc;
			else res -= calc;
		}
			

		System.out.println(res);
		
		}
	
}
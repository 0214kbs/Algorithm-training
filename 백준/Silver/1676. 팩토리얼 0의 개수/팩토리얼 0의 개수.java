import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		int res = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
//		res+= (N/10)*2;
//		if((N%10)>=5) res+=1;
		
		while(N>0) {
			res+= N/5;
			N/=5;
		}
		System.out.println(res);
	}
	
}
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stairs = new int[N+1];
		int[] check = new int[N+1];
		for(int i=1;i<=N;i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		check[1] = stairs[1]; 
		if(N>=2) check[2] = stairs[1]+stairs[2]; 
		for(int i=3;i<=N;i++) {
			check[i] = Math.max(check[i-2], check[i-3]+stairs[i-1]);
			check[i]+=stairs[i];
		}
		
		System.out.println(check[N]);
	}
}
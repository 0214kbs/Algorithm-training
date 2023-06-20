import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {

		// setting
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] s1 = br.readLine().toCharArray();
		char[] s2 = br.readLine().toCharArray();
		
		int[][] check = new int[s1.length+1][s2.length+1];
		int res = 0;
		for(int j=0;j<s2.length;j++) {
			for(int i=0;i<s1.length;i++) {
				if(s1[i]==s2[j]) check[i+1][j+1] = check[i][j]+1;
				else check[i+1][j+1] = Math.max(check[i+1][j], check[i][j+1]);
				res = Math.max(check[i+1][j+1], res);
			}
		}
		
		System.out.println(res);
		
	}
}
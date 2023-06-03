import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static boolean[] check = new boolean[10];
	static int cnt = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int total = (1<<10)-1; 
		
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			
			int cnt = 0; int visited = 0;
			for(cnt=1;;cnt++) {
				char[] arr = String.valueOf(N*cnt).toCharArray();
				for(char c: arr) {
					int num = c-'0';
					visited = visited | (1<<num);
				}
				
				if(visited== total) break;
			}
			
			System.out.println("#"+t+" "+N*cnt);
		}
	}
}
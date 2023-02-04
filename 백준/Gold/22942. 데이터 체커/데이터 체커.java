import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		//setting
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] circles = new int[n][2];
		for(int i=0;i<n;i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			circles[i][0] = x-r;
			circles[i][1] = x+r;
		}
		Arrays.sort(circles, (x1,x2)-> x1[0]-x2[0]);
		boolean res = true;
		int[] p =new int[]{circles[0][0],circles[0][1]};
		for(int i=1;i<n;i++) {
			int [] c = circles[i];
			if(c[1]>=p[1] && c[0]<=p[1]) {
				res = false;
				break;
			}
			p = c;
		}
		System.out.println(res? "YES" : "NO");
	}
}
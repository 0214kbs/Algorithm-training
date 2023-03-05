import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());

			int res = 0;
			StringTokenizer st;
			int a,b,c;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				
				if(a<0 && b<0 && c<0) continue;
				int tmp = Math.max(a, b);
				tmp = Math.max(tmp,c);
				res+= tmp;
			}
			System.out.println(res);
		}
		
	}
}
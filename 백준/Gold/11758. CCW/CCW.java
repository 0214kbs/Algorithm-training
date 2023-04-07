import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int x3 = Integer.parseInt(st.nextToken());
			int y3 = Integer.parseInt(st.nextToken());
			
			int res = x1*y2+x2*y3+x3*y1-x2*y1-x3*y2-x1*y3;
			if(res>0) System.out.println(1);
			else if(res<0) System.out.println(-1);
			else System.out.println(0);
	}
}

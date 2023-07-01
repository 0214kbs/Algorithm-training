import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0, tmp = 0;
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				if(P[i]>P[j]) {
					tmp = P[i];
					P[i] = P[j];
					P[j] = tmp;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<i+1;j++) {
				cnt+= P[j];
			}
		}
		
		System.out.println(cnt);
	}
}
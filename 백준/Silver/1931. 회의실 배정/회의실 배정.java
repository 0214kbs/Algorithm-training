import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		int N = Integer.parseInt(br.readLine());
		int times[][] = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			times[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
			times[i][1] = Integer.parseInt(st.nextToken()); // 끝나는 시간 
		}
		
		
		Arrays.sort(times, (a1, a2) -> {
			if(a1[1] == a2[1]) return a1[0] - a2[0]; 
			return a1[1] - a2[1];
		});

		int res = 1;
		int beforeTime = times[0][1];

		for (int i = 1; i < N; i++) {
			if (times[i][0] >= beforeTime) { 
				beforeTime = times[i][1];
				res++;
			}
		}
		System.out.println(res);
	}
}
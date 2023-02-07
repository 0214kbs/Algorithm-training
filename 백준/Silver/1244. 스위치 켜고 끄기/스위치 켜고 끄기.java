import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] switches = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {

			st = new StringTokenizer(br.readLine());
			int boygirl = Integer.parseInt(st.nextToken());
			int switchnum = Integer.parseInt(st.nextToken());

			switch (boygirl) {
			case 1: // boy
				for (int i = 0; i < n; i++) {
					if ((i+1) % switchnum == 0) {
						switches[i] = (switches[i] == 1) ? 0 : 1;
					}
				}
				break;

			default: // girl
				switches[switchnum-1] = (switches[switchnum-1] == 1) ? 0 : 1;
				for(int i=1;i<n/2;i++) {
					if(switchnum-1+i>=n|| switchnum-1-i<0) break;
					if(switches[switchnum-1-i]==switches[switchnum-1+i]) {
						switches[switchnum-1-i] =(switches[switchnum-1-i] == 1) ? 0 : 1;
						switches[switchnum-1+i] =(switches[switchnum-1+i] == 1) ? 0 : 1;
					}else break;
				}
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(switches[i]).append(" ");
			
			// 스위치의 상태를 1번 스위치에서 시작하여 마지막 스위치까지 한 줄에 20개씩 출력 **
			if((i+1)%20==0) sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
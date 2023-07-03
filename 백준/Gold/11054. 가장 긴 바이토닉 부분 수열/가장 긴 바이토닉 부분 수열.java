import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int arr[] = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] dpLtoR = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			dpLtoR[i] = 1;
			for (int j = 1; j < i; j++) {
				if (arr[i] > arr[j]) {
					dpLtoR[i] = Math.max(dpLtoR[j] + 1, dpLtoR[i]);
				}
			}
		}

		int[] dpRtoL = new int[N + 1];
		for (int i = N; i > 0; i--) {
			dpRtoL[i] = 1;
			for (int j = N; j > i; j--) {
				if (arr[i] > arr[j]) {
					dpRtoL[i] = Math.max(dpRtoL[j] + 1, dpRtoL[i]);
				}
			}
		}

		int res = 0;
		for (int i = 1; i <= N; i++) {
			res = Math.max(res, dpLtoR[i] + dpRtoL[i]);
		}
		System.out.println(res - 1);

	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i < N; i++) {
			int sum = i; 
			int tmp = i;

			while (tmp != 0) {
				sum += tmp % 10;
				tmp /= 10;
			}

			if (sum == N) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}
}
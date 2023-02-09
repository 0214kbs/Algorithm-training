import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int line = 1 + 4 * (n - 1);// 한 줄 길이
		check = new int[line];
		for (int i = 0; i < line; i++)
			check[i] = 0;

		StringBuilder sb = new StringBuilder();
		for (int l = 0; l < line; l++) {
			int calL = (l > line / 2) ? line - l : l;
			for (int i = calL; i < line - calL; i++) {
				check[i] = (check[i] == 1) ? 0 : 1;
			}
			for (int i = 0; i < line; i++) {
				if (check[i] == 1)
					sb.append("*");
				else
					sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}

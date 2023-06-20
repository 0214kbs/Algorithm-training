import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long a, b, c;

	public static void main(String[] args) throws Exception {

		// setting
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		c = Long.parseLong(st.nextToken());

		System.out.println(calc(b));
	}

	static long calc(long b) {
		if (b == 1) return a % c;

		long next = calc(b/2)%c;
		if (b%2 == 1) return ((next * next) % c * a) % c;
		else return (next * next) % c;
	}
}
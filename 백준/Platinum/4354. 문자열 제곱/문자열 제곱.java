import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문자열 제곱
// 문자열 문제
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringBuilder sb = new StringBuilder();
		while(!(str = br.readLine()).equals(".")) {
			int len = str.length();
			int max = 0;
			
//			for(int i = 0; i < len; i++) {
//				String subStr = str.substring(i, len);
//				max = Math.max(max, getMaxKMP(subStr));
//			}
			
//			max = max == 0 ? 1 : max;	//pi의 최댓값이 0이라도, 문자 하나 = 문자^1 이므로, 무조건 1이 나온다.
			max = getMaxKMP(str);
			sb.append(max).append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	// kmp알고리즘으로 pi배열의 최댓값 구하기 
	static int getMaxKMP(String str) {
		int j = 0;
		int max = 0;
		int len = str.length();
		int[] pi = new int[len];
		
		for(int i = 1; i < len; i++) {
			while(j > 0 && str.charAt(i) != str.charAt(j)) {
				j = pi[j - 1];
			}
			if(str.charAt(i) == str.charAt(j)) {
				pi[i] = ++j;
				
//				max = Math.max(max, pi[i]);
			}
		}
		
		// len - pi[len - 1] 이 결국 문자열에서 가장 큰 제곱을 만들 수 있는 가장 작은 문자열이 된다.
		// 그래서, 몇제곱인지 구하기 위해 len / (len - pi[len - 1]) 을 하면 알 수 있다.
		// ex. ababab -> len = 6, pi[len - 1] = 4, len - pi[len - 1] = 2 (ab임을 알 수 있다.)
		// 6 / 2 = 3 (ab를 3번 제곱하면 된다.)
		// 근데 만약, ababa와 같이 문자열의 길이가 홀수고, pi 값이 1보다 큰 경우(이건 3) 나누어떨어지는지 확인해야한다.
		// 문자열의 개수가 홀수인데 제곱이 되지 않으니까! (aaaaa와 같은건 되겠지)
		return len % (len - pi[len - 1]) != 0 ? 1 : len / (len - pi[len - 1]);
	}
}
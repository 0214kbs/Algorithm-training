import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	
	private static final int number = 1000000;
	
	private static long[] sqr;
	private static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sqr = new long[number + 1];
		
		for (int i = 1; i <= number; i++) {
			sqr[i] = (long)i * i;
		}
		
		dp = new int[number + 1];
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append('#').append(t).append(' ');
			long N = Long.parseLong(br.readLine());
			
			if (N <= number) {
				sb.append(getDP((int)N));
				
			} else {
				int temp = binarySearch(N);
				long answer = getDP(temp) + (sqr[temp] - N + 1);
				sb.append(answer);
			}
			
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int getDP(int num) {
		if (num == 2) return 0;
		if (dp[num] != 0) return dp[num];
		int sqrt = (int) Math.sqrt(num);
		if (sqrt * sqrt == num) return dp[num] = getDP(sqrt) + 1;
		else return dp[num] = getDP(num + 1) + 1;
	}
	
	private static int binarySearch(long target) {
		int start = 0;
		int end = number;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			
			if (sqr[mid] < target) {
				start = mid + 1;
				
			} else if (sqr[mid] > target){
				end = mid - 1;
				
			} else {
				return mid;
			}
		}
		
		return start;
	}
}

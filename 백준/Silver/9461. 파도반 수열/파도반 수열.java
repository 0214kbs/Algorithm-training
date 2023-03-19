import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		long[] arr = new long[101];
		arr[1]=arr[2]=arr[3] = 1;
		arr[4]=arr[5]=2;
		int max = 5;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			while(N>max) {
				arr[max+1]= arr[max]+arr[max-4];
				max++;
			}
			sb.append(arr[N]).append("\n");
		}
		System.out.println(sb);
	}
}
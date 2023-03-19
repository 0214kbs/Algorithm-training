import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[12];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;

		int T = Integer.parseInt(br.readLine());
		int max = 3;
		for(int t=0;t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			
			while(n>max) {
				arr[max+1] = arr[max]+arr[max-1]+arr[max-2];
				max++;
			}
			sb.append(arr[n]+"\n");
		}
			
		System.out.println(sb);
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int res = 1;
		Queue<Integer> up = new ArrayDeque<>();
		Queue<Integer> down = new ArrayDeque<>();
		up.add(arr[0]); down.add(arr[0]);
		for(int i=1;i<n;i++) {
			if(arr[i-1]<arr[i]) {
				up.add(arr[i]);
				res = Math.max(res,down.size());
				down.clear();
				down.add(arr[i]);
			}else if(arr[i]==arr[i-1]) {
				up.add(arr[i]);
				down.add(arr[i]);
			}else {
				down.add(arr[i]);
				res = Math.max(res,up.size());
				up.clear();
				up.add(arr[i]);
			}
		}
		res = Math.max(res,down.size());
		res = Math.max(res,up.size());
		System.out.println(res);
	}
}
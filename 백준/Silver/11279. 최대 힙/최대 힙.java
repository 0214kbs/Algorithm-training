import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		// List로 할 경우, n개의 숫자를 출력할 때마다 정렬 -> O(n^2*log n)
		int n= Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			int x = Integer.parseInt(br.readLine());
			if(x==0) {
				if(q.size()==0) sb.append(0).append("\n");
				else sb.append(q.poll()).append("\n");
			}else q.add(x); // add, poll : O(log n)
			
		}
		System.out.println(sb);
	}
}
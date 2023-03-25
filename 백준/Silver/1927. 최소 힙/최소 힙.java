import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			cal(Integer.parseInt(br.readLine()));
		}
		System.out.println(sb);
	}
	static void cal(int n) {
		if(n == 0) {
			if(pq.size()==0) sb.append(0).append("\n");
			else sb.append(pq.poll()).append("\n"); 
		}else pq.add(n);
	}
}
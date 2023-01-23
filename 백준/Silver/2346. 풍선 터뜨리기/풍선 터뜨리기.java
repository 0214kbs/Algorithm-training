import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// memory 초과 -> class로 만들어서 해결?
class Balloon{
	int idx;
	int papers;
	
	public Balloon(int idx, int papers) {
		this.idx = idx;
		this.papers = papers;
	}
}
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // answer
		
		int n = Integer.parseInt(br.readLine());
//		Deque<Integer> q = new LinkedList<>(); // 기존 작성 deque
		Deque<Balloon> q = new ArrayDeque<>(); 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			int v = Integer.parseInt(st.nextToken());
			q.offer(new Balloon(i+1,v));
		}

		while(!q.isEmpty()) {
			sb.append(q.peek().idx).append(" ");
			
			int move = q.poll().papers; // 제일 앞 풍선의 
			if(q.isEmpty()) break;
			if(move>0) {
				for(int m=1;m<move;m++) {
					q.offer(q.poll());
				}
			}else {
				for(int m=0;m<Math.abs(move);m++) {
					q.offerFirst(q.pollLast());
				}
			}
		}

		System.out.println(sb);
	}

}
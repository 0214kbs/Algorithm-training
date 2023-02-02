import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		// setting
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		Deque<int[]> stack = new ArrayDeque<>();
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		// sol
		for(int i=1;i<=n;i++) {
			int top = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty()) {
				// 현재 top 높이보다 더 높을 경우, 
				if(stack.peekLast()[1]>top) {
					sb.append(stack.peekLast()[0]).append(" ");// 해당 top의 위치
					break;
				}
				 // 현재 top이 더 높을때 
				else stack.pollLast();

			}
			
			if(stack.isEmpty())	sb.append(0).append(" ");	// 현재 top보다 높은 게 없을 때.. 
			
			stack.addLast(new int[] {i,top}); // {위치,높이} : 뒤의 탑들의 높이를 모르기때문에 현재 탑 add
		}
		System.out.println(sb);
		
	}

}
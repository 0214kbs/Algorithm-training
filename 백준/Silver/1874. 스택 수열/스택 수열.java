import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); //answer
		Stack<Integer> stack = new Stack<>();
		
	
		int n = Integer.parseInt(br.readLine());
		int cur = 1;
		boolean No = false;
		for(int i=0;i<n;i++) {
			int want = Integer.parseInt(br.readLine());
			
			while(cur<=want) {
				stack.push(cur);
				sb.append('+').append('\n');
				cur++;
				
			}
			if(stack.peek() == want) {
				stack.pop();
				sb.append('-').append('\n');
			}else {
				No = true;
				break;
			}
		}
		if(No) System.out.println("NO"); // No -> NO
		else System.out.println(sb);
	}
	
}
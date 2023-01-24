import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		
		String line = br.readLine();
		int res = 0;
		int mul = 1;
		boolean flag = true;
		
		for(int i=0;i<line.length();i++) {
			switch(line.charAt(i)) {
			
			case '(':
				stack.push('(');
				mul *=2;
				break;		
				
			case '[':
				stack.push('[');
				mul*=3;
				break;
				
			case ')':
				if(stack.isEmpty()|| stack.peek() != '(') {
					flag = false;
					break;
				}				
				if(line.charAt(i-1) == '(') res+= mul;
				stack.pop();
				mul/=2; 
				break;
				
			case ']':
				if(stack.isEmpty()|| stack.peek() != '[') {
					flag = false;
					break;
				}				
				if(line.charAt(i-1) == '[') res+= mul;
				stack.pop();
				mul/=3;
				break;	
			default:
				flag = false;
				break;
			}
			
		}
		
		if(!flag || !stack.isEmpty()) System.out.println(0);
		else System.out.println(res);
	}

}
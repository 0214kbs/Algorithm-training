import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception{
		// setting
		HashMap<Character, Integer> hm = new HashMap<>();
		hm.put('*',2);hm.put('/',2);hm.put('+',1);hm.put('-',1);hm.put('(',0);hm.put(')',0);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Character> dq = new ArrayDeque<>();
		Stack<Character> stack = new Stack<>();	
		StringBuilder sb = new StringBuilder();
		
		char[] charArr = br.readLine().toCharArray();
		
		// sol
		for(int i=0;i<charArr.length;i++) {
            char c = charArr[i];
            if(c=='(') stack.push(c);
            else if(c>=65 && c<=90) sb.append(c);
            else if(c=='+' || c=='-' || c=='*' || c=='/') {
                while(!stack.isEmpty()) {
                	if(hm.get(c)<=hm.get(stack.peek())) {
                        sb.append(stack.pop());
                    }else break;
                }
                stack.push(c);
            }else if(c==')') {
                while(!stack.isEmpty()) {
                    char top = stack.pop();
                    if(top=='(') break;
                    else sb.append(top);
                }
            }
        }
		/*
		for(int i=0;i<charArr.length;i++) {
            char c = charArr[i];
            if(c=='(') dq.add(c);
            else if(c>=65 && c<=90) sb.append(c);
            else if(c=='+' || c=='-' || c=='*' || c=='/') {
                while(!dq.isEmpty()) {
                    if(hm.get(c)<=hm.get(dq.peek())) {
                        sb.append(dq.pollLast());
                    }else break;
                }
                dq.add(c);
            }else if(c==')') {
                while(!dq.isEmpty()) {
                    char top = dq.pollLast();
                    if(top=='(') break;
                    else sb.append(top);
                }
            }
        }
		*/
		
		// output
		/*
		while(!dq.isEmpty()) sb.append(dq.pollLast());
		*/
		while(!stack.isEmpty()) sb.append(stack.pop());
		
		System.out.println(sb.toString());
	}
}
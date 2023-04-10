import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
	
	private static final int MAX = 1000000000;
	private static final int MIN = -1000000000;
	
	private static Stack<Integer> stack;
	private static List<String> cmd;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		outer: while (true) {
			cmd = new ArrayList<>();
			
			while (true) {
				st = new StringTokenizer(br.readLine());
				String input = st.nextToken();
				
				if (input.equals("QUIT")) {
					break outer;
				}
				
				if (input.equals("END")) {
					break;
				}
				
				cmd.add(input);
				
				if (st.hasMoreTokens()) {
					cmd.add(st.nextToken());
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			
			inner: while (N-- > 0) {
				stack = new Stack<>();
				stack.push(Integer.parseInt(br.readLine()));
				
				for (int i = 0; i < cmd.size(); i++) {
					switch (cmd.get(i)) {
						case "NUM": NUM(Integer.parseInt(cmd.get(++i))); break;
						case "POP": 
							if (!POP()) {
								sb.append("ERROR\n");
								continue inner;
							}
							
							break;
							
						case "INV":
							if (!INV()) {
								sb.append("ERROR\n");
								continue inner;
							}
							
							break;
							
						case "DUP":
							if (!DUP()) {
								sb.append("ERROR\n");
								continue inner;
							}
							
							break;
							
						case "SWP":
							if (!SWP()) {
								sb.append("ERROR\n");
								continue inner;
							}
							
							break;
							
						case "ADD":
							if (!ADD()) {
								sb.append("ERROR\n");
								continue inner;
							}
							
							break;
							
						case "SUB":
							if (!SUB()) {
								sb.append("ERROR\n");
								continue inner;
							}
							
							break;
							
						case "MUL":
							if (!MUL()) {
								sb.append("ERROR\n");
								continue inner;
							}
							
							break;
							
						case "DIV":
							if (!DIV()) {
								sb.append("ERROR\n");
								continue inner;
							}
							
							break;
							
						case "MOD":
							if (!MOD()) {
								sb.append("ERROR\n");
								continue inner;
							}
							
							break;
					}
				}
				
				if (stack.size() == 1) {
					sb.append(stack.pop()).append('\n');
					
				} else {
					sb.append("ERROR\n");
				}
			}
			
			sb.append('\n');
			br.readLine();
		}
		
		System.out.print(sb);
	}
	
	private static void NUM(int X) {
		stack.push(X);
	}
	
	private static boolean POP() {
		if (stack.isEmpty()) {
			return false;
		}
		
		stack.pop();
		return true;
	}
	
	private static boolean INV() {
		if (stack.isEmpty()) {
			return false;
		}
		
		int n = stack.pop();
		stack.push(-n);
		return true;
	}
	
	private static boolean DUP() {
		if (stack.isEmpty()) {
			return false;
		}
		
		int num = stack.peek();
		stack.push(num);
		
		return true;
	}
	
	private static boolean SWP() {
		if (stack.size() < 2) {
			return false;
		}
		
		int first = stack.pop();
		int second = stack.pop();
		
		stack.push(first);
		stack.push(second);
		
		return true;
	}
	
	private static boolean ADD() {
		if (stack.size() < 2) {
			return false;
		}
		
		long first = stack.pop();
		long second = stack.pop();
		long result = first + second;
		
		if (result > MAX || result < MIN) {
			return false;
		}
		
		stack.push((int)result);
		return true;
	}
	
	private static boolean SUB() {
		if (stack.size() < 2) {
			return false;
		}
		
		long first = stack.pop();
		long second = stack.pop();
		long result = second - first;
		
		if (result > MAX || result < MIN) {
			return false;
		}
		
		stack.push((int)result);
		return true;
	}
	
	private static boolean MUL() {
		if (stack.size() < 2) {
			return false;
		}
		
		long first = stack.pop();
		long second = stack.pop();
		long result = first * second;
		
		if (result > MAX || result < MIN) {
			return false;
		}
		
		stack.push((int)result);
		return true;
	}
	
	private static boolean DIV() {
		if (stack.size() < 2) {
			return false;
		}
		
		int first = stack.pop();
		int second = stack.pop();
		
		if (first == 0) {
			return false;
		}
		
		stack.push(second / first);
		return true;
	}
	
	private static boolean MOD() {
		if (stack.size() < 2) {
			return false;
		}
		
		int first = stack.pop();
		int second = stack.pop();
		
		if (first == 0) {
			return false;
		}
		
		stack.push(second % first);
		return true;
	}
}

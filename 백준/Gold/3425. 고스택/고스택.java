import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	private static final int MAX = 1000000000;
	private static final int MIN = -1000000000;
	
	private static String[] cmd;
	private static int[] stack;
	private static int index, top;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		cmd = new String[200000];
		
		outer: while (true) {
			index = 0;
			
			while (true) {
				st = new StringTokenizer(br.readLine());
				String input = st.nextToken();
				
				if (input.equals("QUIT")) {
					break outer;
				}
				
				if (input.equals("END")) {
					break;
				}
				
				cmd[index++] = input;
				
				if (st.hasMoreTokens()) {
					cmd[index++] = st.nextToken();
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			
			inner: while (N-- > 0) {
				stack = new int[1000];
				top = -1;
				stack[++top] = Integer.parseInt(br.readLine());
				
				for (int i = 0; i < index; i++) {
					switch (cmd[i]) {
						case "NUM": NUM(Integer.parseInt(cmd[++i])); break;
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
				
				if (top == 0) {
					sb.append(stack[top]).append('\n');
					
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
		stack[++top] = X;
	}
	
	private static boolean POP() {
		if (top == -1) {
			return false;
		}
		
		top--;
		return true;
	}
	
	private static boolean INV() {
		if (top == -1) {
			return false;
		}
		
		int n = stack[top--];
		stack[++top] = -n;
		return true;
	}
	
	private static boolean DUP() {
		if (top == -1) {
			return false;
		}
		
		int num = stack[top];
		stack[++top] = num;
		
		return true;
	}
	
	private static boolean SWP() {
		if (top < 1) {
			return false;
		}
		
		int first = stack[top--];
		int second = stack[top--];
		
		stack[++top] = first;
		stack[++top] = second;
		
		return true;
	}
	
	private static boolean ADD() {
		if (top < 1) {
			return false;
		}
		
		long first = stack[top--];
		long second = stack[top--];
		long result = first + second;
		
		if (result > MAX || result < MIN) {
			return false;
		}
		
		stack[++top] = (int)result;
		return true;
	}
	
	private static boolean SUB() {
		if (top < 1) {
			return false;
		}
		
		long first = stack[top--];
		long second = stack[top--];
		long result = second - first;
		
		if (result > MAX || result < MIN) {
			return false;
		}
		
		stack[++top] = (int)result;
		return true;
	}
	
	private static boolean MUL() {
		if (top < 1) {
			return false;
		}
		
		long first = stack[top--];
		long second = stack[top--];
		long result = first * second;
		
		if (result > MAX || result < MIN) {
			return false;
		}
		
		stack[++top] = (int)result;
		return true;
	}
	
	private static boolean DIV() {
		if (top < 1) {
			return false;
		}
		
		int first = stack[top--];
		int second = stack[top--];
		
		if (first == 0) {
			return false;
		}
		
		stack[++top] = second / first;
		return true;
	}
	
	private static boolean MOD() {
		if (top < 1) {
			return false;
		}
		
		int first = stack[top--];
		int second = stack[top--];
		
		if (first == 0) {
			return false;
		}
		
		stack[++top] = second % first;
		return true;
	}
}

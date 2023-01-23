import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// String -> ascii (int)str.toCharArray()[0]-65
public class Main {
	static double change(String s, double[] numList) {
		if(Character.isLetter(s.charAt(0))) {// 문자인경우
			int idx = (int)(s.charAt(0))-65;
			return numList[idx];
		}else {
			return Double.parseDouble(s);
		}
		
	}
	public static void main(String[] args) throws Exception {
		
		Stack<String> stack = new Stack<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		double[] numList = new double[n];
		
		String line = br.readLine();
		
		for(int i=0;i<n;i++) {
			numList[i] = Double.parseDouble(br.readLine());
		}
		for(int i=0;i<line.length();i++) {
			if(line.charAt(i)=='+') {
				double first = change(stack.pop(),numList);
				double second = change(stack.pop(),numList);
				stack.add(String.valueOf(second+first));
			}
			else if(line.charAt(i)=='-') {
				double first = change(stack.pop(),numList);
				double second = change(stack.pop(),numList);
				stack.add(String.valueOf(second-first));
			}
			else if(line.charAt(i)=='*') {
				double first = change(stack.pop(),numList);
				double second = change(stack.pop(),numList);
				stack.add(String.valueOf(second*first));
			}
			else if(line.charAt(i)=='/') {
				double first = change(stack.pop(),numList);
				double second = change(stack.pop(),numList);
				stack.add(String.valueOf(second/first));
			}
			else {
				stack.add(line.substring(i,i+1));
			}
		}
		System.out.printf("%.2f",Double.parseDouble(stack.pop()));
		
	}
}

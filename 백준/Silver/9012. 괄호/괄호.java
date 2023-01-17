import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            String line = br.readLine();
            boolean isVPS = true;
            for (int j = 0; j < line.length(); j++) {
                if(line.charAt(j)=='('){
                    stack.push('(');
                }else{  // ')'        
                    if(stack.isEmpty())    {
                        isVPS=false;
                        break;
                    }
                    else stack.pop();            
                }
            }
            if(!isVPS||!stack.isEmpty()) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}

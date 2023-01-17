import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
/**
 * 10828
 */
public class Main {
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //선언
        int n = Integer.parseInt(br.readLine()); //Int
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(st.hasMoreTokens()){ //push
                int x = Integer.parseInt(st.nextToken());
                stack.push(x);
            }
            if(order.equals("pop")) {
                if(stack.size()==0) System.out.println(-1);
                else System.out.println(stack.pop());
            }
            if(order.equals("size")) System.out.println(stack.size());
            if(order.equals("empty")) {
                if(stack.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }
            if(order.equals("top")) {
                if(stack.size()==0) System.out.println(-1);
                else System.out.println(stack.peek());
            }
        }

    }   
}
import java.util.Deque;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        Deque<Integer> q = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //선언
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine()); //Int

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(st.hasMoreTokens()){ //push
                int x = Integer.parseInt(st.nextToken());
                q.offer(x);
            }
            if(order.equals("pop")) {
                
                if(q.size()==0) sb.append(-1).append('\n');
                else sb.append(q.poll()).append('\n');
            }
            if(order.equals("size")) sb.append(q.size()).append('\n');
            if(order.equals("empty")) {
                if(q.isEmpty()) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            }
            if(order.equals("front")){
                if(q.peek() == null) sb.append(-1).append('\n');
                else sb.append(q.peek()).append('\n');
            }
            if(order.equals("back")){
                if(q.peekLast() == null) sb.append(-1).append('\n');
                else sb.append(q.peekLast()).append('\n');
            }
            
        }
    System.out.println(sb);
    }
}

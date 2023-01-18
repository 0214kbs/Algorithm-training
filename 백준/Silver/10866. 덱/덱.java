import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //선언
        int n = Integer.parseInt(br.readLine()); //Int
        Deque<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            //push_back, push_front
            if(st.hasMoreTokens()){ 
                int x = Integer.parseInt(st.nextToken());
                if(order.equals("push_front")) q.offerFirst(x);
                else if(order.equals("push_back")) q.offerLast(x);
            }else{
                //pop_front
                if(order.equals("pop_front")){
                    if(!q.isEmpty())   sb.append(q.pollFirst()).append("\n");
                    else sb.append(-1).append("\n");
                }
                //pop_back
                if(order.equals("pop_back")){
                    if(!q.isEmpty())    sb.append(q.pollLast()).append("\n");
                    else sb.append(-1).append("\n");
                }
                //size
                if(order.equals("size"))     sb.append(q.size()).append("\n");
                if (order.equals("empty")) {
                    if(q.isEmpty())  sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                }
                //front
                if (order.equals("front")) {
                    if(q.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(q.peekFirst()).append("\n");
                }
                //back
                if (order.equals("back")) {
                    if(q.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(q.peekLast()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}

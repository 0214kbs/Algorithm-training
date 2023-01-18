import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k  = sc.nextInt();
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.offer(i+1);
        }
        while (q.peek()!=null) {
            for (int i = 0; i < k-1; i++) {
                int tmp = q.poll();
                q.offer(tmp);
            }
            
            int tmp2 = q.poll();
            if(sb.length()==1) sb.append(tmp2);
            else sb.append(", "+tmp2);
        }


        sb.append(">");
        sc.close();

        System.out.println(sb);
    }   
}
import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) {
        Deque<Integer> q = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        for (int i = 0; i < n; i++) {
            q.offer(i+1);
        }
        while(q.size()>1){
            q.poll();
            if(q.size()>1){
                int tmp = q.poll();
                q.offer(tmp);
            }
        }
        System.out.println(q.peek());
        sc.close();
    }
}

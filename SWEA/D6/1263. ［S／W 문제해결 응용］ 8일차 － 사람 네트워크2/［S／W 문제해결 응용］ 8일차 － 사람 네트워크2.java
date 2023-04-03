import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
         
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
             
            int N = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] adList = new ArrayList[N + 1];
             
            for (int i = 1; i <= N; i++) {
                adList[i] = new ArrayList<Integer>();
                for (int j = 1; j <= N; j++)
                    if(st.nextToken().charAt(0) == '1')
                        adList[i].add(j);
            }
             
            int min = 1000001;
            for (int i = 1; i <= N; i++) {
                boolean[] check = new boolean[N + 1];
                 
                Queue<Integer> q = new ArrayDeque<>();
                q.add(i);
                check[i] = true;
                 
                int sum = 0;
                int dist = 0;
                int cnt = 1;
x:              while(!q.isEmpty()) {
                    int len = q.size();
                    dist++;
                     
                    while(len-- > 0) {
                        int n = q.poll();
                        for (Integer next : adList[n]) {
                            if(!check[next]) {
                                q.add(next);
                                check[next] = true;
                                sum += dist;
                                if(++cnt == N) break x;
                            }
                        }
                    }
                }
                 
                min = Math.min(sum, min);
            }
            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }
}
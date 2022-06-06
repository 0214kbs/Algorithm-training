import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<=n;i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0;i<m;i++){
            String[] str2 = br.readLine().split(" ");
            int n1 = Integer.parseInt(str2[0]);
            int n2 = Integer.parseInt(str2[1]);

            graph.get(n2).add(n1);
        }
       
        int max = 0;
        int[] depths = new int[n+1];
        for(int i = 1;i<=n;i++){
            // System.out.println("--------------------"+i);
            boolean[] visited = new boolean[n+1];
            Queue<Integer> q = new LinkedList<>();
                // visited[i] = true;
            q.offer(i);

            while(!q.isEmpty()){
                int index = q.poll();
                visited[index] = true;
                ArrayList<Integer> sub = graph.get(index);
                for(int num:sub){
                    if(!visited[num]){
                        // System.out.println(num);
                        depths[i]+=1;
                        visited[num]=true;
                        q.offer(num);
                    }
                }
            }

            if(max<depths[i])   max = depths[i];
        }
        // System.out.println(Arrays.toString(depths));
        StringBuilder sb = new StringBuilder();
        for(int i =1;i<=n;i++){
            if(depths[i] == max)    sb.append(i).append(" ");
        }
        System.out.println(sb.toString());

    }

}

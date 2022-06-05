import java.util.*;
import java.io.*;

public class Main {
    public static void find_parent(int parent,int current, ArrayList<Integer>[] graph, int[] parents,int n){

        parents[current] = parent;
        for(int i : graph[current]){

            // parent = current;
            if(i != parent) find_parent(current,i,graph,parents,n);
        }

    }
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str_n = br.readLine();
        int n = Integer.parseInt(str_n);

        // ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i = 0;i<=n;i++){
            // graph.add(new ArrayList<>());
            graph[i] = new ArrayList<Integer>();
        }
        for(int i = 0;i<n-1;i++){
            String[] str_c = br.readLine().split(" ");
            int n1 = Integer.parseInt(str_c[0]);
            int n2 = Integer.parseInt(str_c[1]);

            // graph.get(n1).add(n2);
            // graph.get(n2).add(n1);
            graph[n1].add(n2);
            graph[n2].add(n1);
        }
        
        int[] parents = new int[n+1];
        
        find_parent(0,1,graph,parents,n);
        for(int i=2;i<=n;i++){
            System.out.println(parents[i]);
        }
        
    }
}

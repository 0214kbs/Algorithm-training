import java.util.*;
// import java.io.*;

public class Main {
    public static void combination(int[] arr,int m, int start, int depth, boolean[] visited) {
        if(depth == m){
            for(int i =0;i<arr.length;i++){
                if(visited[i]){
                    System.out.print(arr[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
            return;
        }
        for(int i = start;i<arr.length;i++){
            if(!visited[i]){
                visited[i] = true;
                combination(arr, m, i+1, depth+1, visited);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 1;i<=n;i++){
            arr[i-1] = i;
        }
        sc.close();
        combination(arr,m, 0,0, new boolean[n]);
    }

}

import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int a=0;a<commands.length;a++){
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];
            
            int[] arr2 = new int[j-i+1];
            for(int b=i-1;b<j;b++){
                arr2[b-(i-1)]= array[b];
            }
            Arrays.sort(arr2);
            answer[a]=arr2[k-1];
            
        }
        
        return answer;
    }
}
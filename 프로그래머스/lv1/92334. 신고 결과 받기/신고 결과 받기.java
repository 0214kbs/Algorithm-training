import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        boolean[][] check = new boolean[id_list.length][id_list.length];
        int[] count = new int[id_list.length];
        int[] answer = new int[id_list.length];
        Map<String, Integer> id = new HashMap<>();
        for(int i=0;i<id_list.length;i++){
            id.put(id_list[i],i);
        }
        for(int i=0;i<report.length;i++){
            StringTokenizer st = new StringTokenizer(report[i]);
            int a = id.get(st.nextToken());
            int b = id.get(st.nextToken());
            
            if(!check[a][b]) count[b]++;
            check[a][b] = true;
            
        }
        
        for(int i=0;i<id_list.length;i++){
            if(count[i]>=k){          
                for(int j=0;j<id_list.length;j++){
                    if(check[j][i]) answer[j]++;
                }
            }
        }
        return answer;
    }
}
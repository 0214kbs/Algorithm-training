import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //ì„ ì–¸
        int t = Integer.parseInt(br.readLine());
        int[] res = new int[t];
        for(int i = 0;i<t;i++) {
        	//setting
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] maxArr = new int[n]; // 우선순위 저장
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            Deque<Integer> q = new LinkedList<>();
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int j=0;j<n;j++) {
            	q.offer(j);	// q : paper's index
            	int prior = Integer.parseInt(st2.nextToken());
            	map.put(j, prior);
            	maxArr[j] = prior;
            }
            Arrays.sort(maxArr);
            
            int pollNum = 0;
            for(int big=maxArr.length-1;big>=0;big--) {
            	while(map.get(q.peek())!=maxArr[big]) {
            		q.add(q.poll());
            	}
            	if(q.peek()==m) {
            		pollNum++;
            		res[i] = pollNum;
            		
            		break;
            	}
            	q.poll();
            	pollNum++;
            }
        }
        for(int r :res) {
        	System.out.println(r);
        }
	}

}
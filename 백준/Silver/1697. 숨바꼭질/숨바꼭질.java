import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int min = Integer.MAX_VALUE;
	static int[] visit = new int[100005]; // 방문 check && 초기값 0이 수 다음 값, 이전 값 계산 활용 
	static Queue<Integer> q = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(N<K) {
			System.out.println(bfs(N,K));
		}
		else if(N>K) System.out.println(N-K);
		else System.out.println(0);
	}
	
	static int bfs(int N, int K) {
		int minus = 0;
		int plus = 0;
		int multi = 0;
		
		visit[N] = 0;
		q.add(N);

		while(!q.isEmpty()){
			int cur = q.poll();
			
			if(cur == K) break; // q에 들어가면서 K에 대한 visit 계산이 되어 있다. 
			
			minus = cur-1;
			plus = cur+1;
			multi= cur*2;
			
			if(minus>=0 && visit[minus] == 0) {
				visit[minus] = visit[cur]+1; // minus까지 오는 동안 걸린 횟수 = 바로 이전 cur까지 오는 횟수+1
				q.offer(minus);
			}
            if(cur>K) continue;
			if(plus<= 100000&& visit[plus] == 0) {
				visit[plus] = visit[cur]+1; 
				q.offer(plus);
			}
			if(multi<= 100000&& visit[multi] == 0) {
				visit[multi] = visit[cur]+1; // minus까지 오는 동안 걸린 횟수 = 바로 이전 cur까지 오는 횟수+1
				q.offer(multi);
			}
		}
		return visit[K];
	}
	
}

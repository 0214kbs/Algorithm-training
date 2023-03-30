import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, allMask, INF = 987654321;
	static int[][] W;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// 자료구조 
		allMask = (1<<N)-1;
		// ex 5개 도시 : 11111  
		//=> 1 << 5 (= 100000) -1 (= 11111) 
		W = new int[N][N];
		dp = new int[N][allMask];
		
		// 입력
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 풀이
		System.out.println(tsp(0,1));
	}
	
	// idx 도시부터 아직 방문하지 않은 남은 모든 도시를 방문하는 최소 비용을 return 
	static int tsp(int idx, int mask) {
		// 기저 조건
		// 모든 도시를 방문 => 돌아가는 비용 확인
		if(mask == allMask) {
			if(W[idx][0] == 0) return INF; // 처음으로 되돌아 가지 못하는 경우
			else return W[idx][0]; // 처음으로 되돌아가는 비용 리턴 
		}
		
		// 이미 이전에 계산된 값이 존재
		if(dp[idx][mask]!=0) return dp[idx][mask];
		
		
		// 최소비용 INF 초기화
		dp[idx][mask] = INF;
		// 남은 도시를 모두 방문하는 최소 비용을 계산
		for(int i=0;i<N;i++) {
			// 갈 수 있거나, 이미 방문했으면 skip
			if(W[idx][i]==0 || (mask & (1<<i)) != 0) continue; 
			// 남은 i를 거치는 비용과 현재 비용을 비교하면서 최소 값을 갱신
			dp[idx][mask] = Math.min(dp[idx][mask], tsp(i,mask|(1<<i))+W[idx][i]); // mask에 i번째도 간다라는 표시
			
		}
		return dp[idx][mask];
		
	}
}

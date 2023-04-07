import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static long[] nums, tree;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());

	    nums = new long[N + 1]; // 0 dummy
	    tree = new long[N + 1]; // 0 dummy
	    
	    for (int i = 1; i <= N; i++) {
	        st = new StringTokenizer(br.readLine());
	        nums[i] = Long.parseLong(st.nextToken());
	    }
	    
	    // 펜윅 트리 구성
	    for (int i = 1; i <= N; i++) {
	        update( i, nums[i]);// 최소 tree 생성시에는 배열이 0 이므로 값을 그대로 전달하면 그것이 diff
	    }
	    
	    // 변경 또는 합
	    for (int i = 0; i < M + K; i++) {
	        st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken());
	        
	        if( a == 1 ) { // b 번째 수를 c 로 변경
	            int b = Integer.parseInt(st.nextToken());
	            long c = Long.parseLong(st.nextToken());
	            long temp = nums[b];
	            nums[b] = c; // 원본 배열 의 b 자리를 c 로 변경
	            update( b, c - temp );
	        }else if( a == 2 ) { // b 번째 ~ c 번째 수의 합
	            int b = Integer.parseInt(st.nextToken());
	            int c = Integer.parseInt(st.nextToken());
	            long s = sum(b, c);
	            System.out.println(s);
	        }
	    }
	}

	static void update(int i, long diff) {
	    while( i < N + 1 ){
	        tree[i] += diff;
	        i += ( i & -i);
	    }
	}

	static long sum(int i) {
	    long result = 0;
	    while( i > 0 ) {
	        result += tree[i];
	        i -= ( i & -i );
	    }
	    return result;        
	}

	static long sum(int i, int j) {
	    return sum(j) - sum(i-1);
	}
}

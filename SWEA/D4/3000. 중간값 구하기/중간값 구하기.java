import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			int res = 0;
			sb.append("#" + test_case + " ");
			
			PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> right = new PriorityQueue<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int mid = Integer.parseInt(st.nextToken());
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int leftCnt = 0;
				int rightCnt = 0;
				
				if(mid<x) {
					rightCnt ++;
					right.add(x);
				}
				else{
					leftCnt++;
					left.add(x);
				}
				
				if(mid<y) {
					rightCnt++;
					right.add(y);
				}
				else {
					leftCnt++;
					left.add(y);
				}
				
				if(leftCnt == 1 && rightCnt ==1) {
//					continue;
				}
				else if(leftCnt == 2) {
					int l = left.poll();
					right.add(mid);
					mid = l;
				}
				else if(rightCnt ==2) {
					int r = right.poll();
					left.add(mid);
					mid = r;
				}
				
				res+= mid;
				res%=20171109;
				
			}
			res%=20171109;
			sb.append(res+"\n");
			
		}
		System.out.println(sb);
	}
}
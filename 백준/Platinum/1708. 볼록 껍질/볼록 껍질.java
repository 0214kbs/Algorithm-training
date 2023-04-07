
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long sx, sy;
	static long[][] point;
	
	
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    point = new long[N][2];
	    
	    // 시작점 입력처리하면서 확인
	    // 우선 입력 첫 번째를 시작점으로 하고 그 다음 입력부터 가장 아래 또는 왼쪽 기준으로
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    sx = point[0][0] = Long.parseLong(st.nextToken());
	    sy = point[0][1] = Long.parseLong(st.nextToken());
	    
	    for(int i=1;i<N;i++) {
	    	st = new StringTokenizer(br.readLine());
	    	point[i][0] = Long.parseLong(st.nextToken());
	    	point[i][1] = Long.parseLong(st.nextToken());
	    	
	    	if(sy>point[i][1]) {
	    		sx = point[i][0];
	    		sy = point[i][1];
	    	}else if(sy==point[i][1] && sx>point[i][0]) {
	    		sx = point[i][0];
	    		sy = point[i][1];
	    	}
	    }
		// 시작점 완료
	    // 모든 점들을 대상으로 시작점 기준으로ccw을 이용해서 반시계방향으로 정렬, 직선상이면 가까운 것으로
	    Arrays.sort(point, (p1,p2)->{
	    	int ret = ccw(sx,sy,p1[0],p1[1],p2[0],p2[1]);
	    	if(ret>0) return -1; // 반시계 방향
	    	else if(ret<0) return 1; // 시계 방향이면 뒤로 
	    	else {
	    		long diff = distance(sx,sy,p1[0],p1[1])-distance(sx,sy,p2[0],p2[1]);
	    		return diff>0? 1: -1;
	    	}
	    });
	    
	    Stack<long[]> stack = new Stack<>();
	    stack.add(new long[] {sx,sy});
	    // 스택을 이용해서 정렬된 순서대로 시계, 반시계 방향 고려해서 볼록 껍질을 완성해감
	    int length = point.length;
	    for(int i=1;i<length;i++) {
	    	long[] next = point[i];
	    	while(stack.size()>1) {
	    		long[] first = stack.get(stack.size()-2);
	    		long[] second = stack.get(stack.size()-1);
	    		
	    		int ret = ccw(first[0], first[1], second[0], second[1], next[0], next[1]);
	    		if(ret<=0) stack.pop();
	    		else break;
	    	}
	    	stack.add(point[i]);
	    }
	    System.out.println(stack.size());
	}
	static int ccw(long x1, long y1,long x2, long y2,long x3, long y3) {
		long ret = x1*y2+x2*y3+x3*y1-x2*y1-x3*y2-x1*y3;
		if(ret>0) return 1;
		else if(ret<0) return -1;
		else return 0;
	}
	
	static long distance(long x1, long y1, long x2, long y2) {
		return (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
	}
}

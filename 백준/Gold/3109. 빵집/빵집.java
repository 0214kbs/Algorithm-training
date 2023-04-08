import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = {-1,0,1}; // 우상 우 우하 (우선순위 순) // dx는 오른쪽으로만 가기때문에 필요 없음
	static char [][] map;
	static int r,c,res;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][];
		
		for(int i=0;i<r;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0;i<r;i++) {
			if(dfs(i,0)) res++;
		}
		System.out.println(res);
	}
 
	static boolean dfs(int y, int x) {
		int nx = x+1;
		if(x==c-1) return true; // 1. 맨끝 도착
		
		for(int d=0;d<3;d++) {
			int ny = y+dy[d];
			
			if(ny<0||ny>=r||map[ny][nx]=='x') continue;
			else{
				map[ny][nx] = 'x'; // 이미 방문함. 성공해도 실패해도 다시 올필요없음
				if(dfs(ny,nx)) return true; // 2. 자신의 좌표보다 다음 좌표 재귀 호출 결과가 true 
			}
		}
		return false;
	}
}

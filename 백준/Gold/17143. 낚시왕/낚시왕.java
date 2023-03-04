
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int R,C,M, sum;
	static Shark[][] map;
	static List<Shark> list = new ArrayList<>();
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	
	static class Shark{
		int r;
		int c;
		int s; // 속력
		int d; // 이동방향
		int z; // 크기
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Shark[R+1][C+1];

		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine());
			int r= Integer.parseInt(st.nextToken());
			int c= Integer.parseInt(st.nextToken());
			int s= Integer.parseInt(st.nextToken());
			int d= Integer.parseInt(st.nextToken()); 
			int z= Integer.parseInt(st.nextToken());
			Shark shark = new Shark(r,c,s,d-1,z); // d는 delta와 맞추기 위해 -1
			list.add(shark);
			map[r][c] = shark;
		}
		
		// simulation
		for(int i=1;i<=C;i++) {
			catchShark(i); // i번째 컬럼
			moveShark();
			killShark(); // 정리
		}
		
		System.out.println(sum);
	}


	static void catchShark(int col) {
		// 현재 열에서 가장 가까운 상어 취득
		// map 삭제 <= killShark()에서
		for (int i = 1; i <=R; i++) {
			if(map[i][col] != null) {
				sum+= map[i][col].z;
				list.remove(map[i][col]);
				break;
			}
		}
	}
	
	// 
	static void moveShark() {
		// list에서 하나씩 처리 (map X)
		for(Shark shark: list) {
			int r = shark.r;
			int c = shark.c;
			int s = shark.s;
			int d = shark.d;
			
			// 방향에 따라 이동 처리
			// 위 아래 같이 처리, 우좌 같이 처리 
			switch(d) {
			case 0:
			case 1:
				s = s%(R*2 -2); // s 보정
				for(int i=0;i<s;i++) {
					if(r==1) d=1; // 하 변경
					else if(r==R) d = 0; // 상 변경 
					r += dr[d];
				}
				shark.r = r;
				shark.d = d;
				break;
			case 2:
			case 3:
				s = s%(C*2 -2); // s 보정
				for(int i=0;i<s;i++) {
					if(c==1) d=2; // 우 변경
					else if(c==C) d = 3; // 좌 변경 
					c += dc[d];
				}
				shark.c = c;
				shark.d = d;
				break;
			}
		}
	}
	static void killShark() {
		// 맵 초기화 
		// 겹치는 상어 정리 
		for (int i = 1; i <= R ; i++) {
			for (int j = 1; j <= C ; j++) {
				map[i][j] = null;
			}
		}
		
		int size = list.size();
		for (int i = size-1; i>=0 ; i--) {
			Shark s = list.get(i);
			if(map[s.r][s.c]== null) {
				map[s.r][s.c] = s;
			}else {
				if(s.z > map[s.r][s.c].z) {
					list.remove(map[s.r][s.c]);
					map[s.r][s.c]= s; 
				}else { // 이미 map에 있는 상어가 우선
					list.remove(s);
				}
			}
		}
	}
}

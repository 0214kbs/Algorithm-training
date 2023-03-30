import java.io.*;
import java.util.*;

class Main{
	
	private static class Point {
		int r;
		int c;
		int turn;
		
		public Point() {}
		
		public Point(int r, int c, int turn) {
			this.r = r;
			this.c = c;
			this.turn = turn;
		}
	}
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int startX,startY;
    public static void main(String[] args)throws Exception{
        ArrayDeque<Point> queue = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] dxy = {{0,1},{0,-1},{1,0},{-1,0}};
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][]map = new char[R][C];
        for(int i=0; i<R;i++)
            for(int j=0; j<C; j++){
            	map[i][j] = read();
                if(map[i][j]=='J'){
                    startX = i;
                    startY = j;
                }else if(map[i][j]=='F'){
                	queue.add(new Point(i, j, 0));
                }
            }
        
        queue.add(new Point(startX, startY, 0));
        
        while (!queue.isEmpty()) {
			Point curr = queue.poll();
				
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
					
				if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
					if (map[curr.r][curr.c] == 'J') {
						System.out.println(curr.turn + 1);
						return;
					}
					
					continue;
				}
				
				if (map[nr][nc] != '.') {
					continue;
				}
					
				queue.offer(new Point(nr, nc, curr.turn + 1));
				map[nr][nc] = map[curr.r][curr.c];
			}
		}
		
		System.out.print("IMPOSSIBLE");
    }
    public static char read()throws Exception{
        while(true){
            int num = br.read();
            if(num!='\n')
                return (char)num;
        }
    }
}
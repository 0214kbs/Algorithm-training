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
	
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int startX,startY;
    public static void main(String[] args)throws Exception{
        ArrayDeque<Point> q = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] dxy = {{0,1},{0,-1},{1,0},{-1,0}};
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        char[][]map = new char[x][y];
        for(int i=0; i<x;i++)
            for(int j=0; j<y; j++){
            	map[i][j] = read();
                if(map[i][j]=='J'){
                    startX = i;
                    startY = j;
                }else if(map[i][j]=='F'){
                    q.add(new Point(i, j, 0));
                }
            }
        
        q.add(new Point(startX, startY, 0));
        
        while(!q.isEmpty()){
            Point curr = q.poll();
            
            for(int[] xy : dxy){
                int nr = curr.r + xy[0];
                int nc = curr.c + xy[1];
                int dist = curr.turn + 1;
                
                if (nr < 0 || nr >= x || nc < 0 || nc >= y) {
					if (map[curr.r][curr.c] == 'J') {
						System.out.println(dist);
						return;
					}
					
					continue;
				}

                if (map[nr][nc] != '.') {
					continue;
				}
                
                map[nr][nc] = map[curr.r][curr.c];
                q.add(new Point(nr,nc,dist));
                
            }
        }
        System.out.println("IMPOSSIBLE");
    }
    public static char read()throws Exception{
        while(true){
            int num = br.read();
            if(num!='\n')
                return (char)num;
        }
    }
}
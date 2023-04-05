import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,d,k,c,cnt;
	static int[] selected;
	static int[] dish;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		dish = new int[n];
		selected = new int[3001];
		
		for(int i=0;i<n;i++) {
			dish[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0;i<k;i++) {
			if(selected[dish[i]]==0) cnt++;
			selected[dish[i]]++;
		}
		int res = cnt;
		
		for(int i=0;i<n;i++) {
			if(res<=cnt) {
				if(selected[c] == 0) res = cnt+1;
				else res = cnt;
			}
			
			if(selected[dish[i]]==1) cnt-=1;
			selected[dish[i]]--;
			
			if(selected[dish[(i+k)%n]]==0) cnt+=1;
			selected[dish[(i+k)%n]]++;
		}
		System.out.println(res);
	}
}
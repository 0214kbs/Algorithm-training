import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		int cnt = 0;
		int res = 0;
		
		int i=1;
		while(i<M-1) {
            if(str.charAt(i) == 'O' && str.charAt(i+1) == 'I') {
                cnt++;
                if(cnt == N) {
                    if(str.charAt(i-(cnt*2-1)) == 'I') res++;
                    cnt--;
                }
                i += 2;
            }
            else {
                cnt = 0;
                i++;
            }
        }
        System.out.println(res);
    }
	
}

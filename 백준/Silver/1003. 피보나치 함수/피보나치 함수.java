import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static class Pair{
		int zero;
		int one;
		public Pair(int zero, int one) {
			this.zero = zero;
			this.one = one;
		}
	}

//	static List<Pair> arr = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		Pair[] arr = new Pair[41];
		
		arr[0] = new Pair(1,0);
		arr[1] = new Pair(0,1);
		int max = 1;
//		arr.add(new Pair(1,0));
//		arr.add(new Pair(0,1));

		for(int t=0;t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			if(n>max) {
				while(true) {
					if(max==n) break;
					arr[max+1] = new Pair(arr[max].zero+arr[max-1].zero,arr[max].one+arr[max-1].one);
					max+=1;
				}
			}
			sb.append(arr[n].zero+" "+arr[n].one+"\n");
		}
		System.out.println(sb);
	}

}
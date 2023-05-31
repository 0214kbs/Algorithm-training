import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Pair> list = new ArrayList<>();
		int cnt = 1;
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			String b = st.nextToken();
			list.add(new Pair(a,cnt,b));
			cnt++;
		}
		Collections.sort(list, (p1,p2) ->{
			if(p1.age==p2.age) return p1.num-p2.num;
			return p1.age-p2.age;
		});
		
		// output
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(list.get(i).age).append(" ").append(list.get(i).name).append("\n");
		}
		System.out.println(sb);
	}
	
	static class Pair{
		int age;
		int num;
		String name;

		public Pair() {
			super();
		}

		public Pair(int age, int num, String name) {
			super();
			this.age = age;
			this.num = num;
			this.name = name;
		}
		
	}
}
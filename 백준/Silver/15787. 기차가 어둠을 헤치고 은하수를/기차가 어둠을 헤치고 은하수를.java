import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws Exception {
		
		// setting
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer>[] trains = new ArrayList[N];
	    for(int i=0; i<N; i++) { 
	    	trains[i] = new ArrayList<>();
	    }
		int order,i,x;
		
		
		// order 처리 
		for (int o = 0; o < M; o++) {
			st = new StringTokenizer(br.readLine());
			
			order = Integer.parseInt(st.nextToken());
			i = Integer.parseInt(st.nextToken())-1;
			
			switch (order) {
			case 1:
				x = Integer.parseInt(st.nextToken());
				// 없으면 추가 
				if(!trains[i].contains(x)) trains[i].add(x);
				Collections.sort(trains[i]);
				break;
			case 2:
				x = Integer.parseInt(st.nextToken());
				// 있으면 제거 
				if(trains[i].contains(x)) trains[i].remove(trains[i].indexOf(x));
				break;
			case 3:
				for(int idx=0;idx<trains[i].size();idx++) {
					trains[i].set(idx, trains[i].get(idx)+1);
				}
				if(trains[i].isEmpty()) break;
				if(trains[i].get(trains[i].size()-1)==21) trains[i].remove(trains[i].size()-1);
				break;
			case 4:
				for(int idx=0;idx<trains[i].size();idx++) {
					trains[i].set(idx, trains[i].get(idx)-1);
				}
				if(trains[i].isEmpty()) break;
				if(trains[i].get(0)==0) trains[i].remove(0);
				break;
			}
		}
		
		HashSet<String> res = new HashSet<>();
		for(int t=0;t<N;t++) {
			res.add(trains[t].toString());
		}
		System.out.println(res.size());
	}


	
}

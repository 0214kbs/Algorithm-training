import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); //answer
		
		PriorityQueue<Integer> pqPlus = new PriorityQueue<>();
		PriorityQueue<Integer> pqMinus = new PriorityQueue<>(Collections.reverseOrder());
		
		int n= Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			int x= Integer.parseInt(br.readLine());
			if(x==0) {
				if(pqPlus.size()==0 && pqMinus.size()==0) sb.append(0).append("\n");
				else {
					if(pqPlus.size()==0) sb.append(pqMinus.poll()).append("\n");
					else if(pqMinus.size()==0) sb.append(pqPlus.poll()).append("\n");
					else {
						if(pqPlus.peek() >= Math.abs(pqMinus.peek())) sb.append(pqMinus.poll()).append("\n");
						else sb.append(pqPlus.poll()).append("\n");
					}
				}

			}
			else if(x>0) pqPlus.add(x);
			else pqMinus.add(x);
		}
		
		System.out.println(sb);
	}
}
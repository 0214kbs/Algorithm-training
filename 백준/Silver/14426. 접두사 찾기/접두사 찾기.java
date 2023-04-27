import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Node t = new Node();
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			Node tmp = t;
			for(int j = 0; j<str.length(); j++) {
				char c = str.charAt(j);
				if(tmp.next[c-'a']==null) {
					tmp.next[c-'a']= new Node();;
				}
				tmp = tmp.next[c-'a'];
			}
		}
		
		int cnt=0;
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			Node tmp = t;
			for(int j = 0; j<str.length(); j++) {
				char c = str.charAt(j);
				
				Node tt = tmp.next[c-'a'];
				tmp = tt;
				if(tt==null) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(M-cnt);
	}

}

class Node{
	Node[] next = new Node[26];
}

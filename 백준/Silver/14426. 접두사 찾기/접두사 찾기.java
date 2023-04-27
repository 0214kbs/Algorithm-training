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
			add(br.readLine(), t);
		}
		
		int cnt=0;
		for(int i=0; i<M; i++) {
			cnt+=find(br.readLine(), t);
		}
		
		System.out.println(M-cnt);
	}
	
	static void add(String str, Node t) {
		Node tmp = t;
		for(int j = 0; j<str.length(); j++) {
			char c = str.charAt(j);
			if(tmp.next[c-'a']==null) {
				tmp.next[c-'a']= new Node();
			}
			tmp = tmp.next[c-'a'];
		}
	}
	
	static int find(String str, Node t) {
		Node tmp = t;
		for(int j = 0; j<str.length(); j++) {
			char c = str.charAt(j);
			
			Node tt = tmp.next[c-'a'];
			tmp = tt;
			if(tt==null) {
				return 1;
			}
		}
		return 0;
	}
}

class Node{
	Node[] next = new Node[26];
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int res = 0;
		Trie trie = new Trie();
		for(int i=0;i<N;i++) {
			String s = br.readLine();

			// insert
			trie.insert(s);
		}
		
		for(int i=0;i<M;i++) {
			String s = br.readLine();
			// search
			if(trie.search(s)) res++;
		}
		
		System.out.println(res);
	}
	
	static class TrieNode{
		boolean isExist; // 마지막 글자
		TrieNode[] children; // 자식노드 저장
		
		TrieNode(){
			isExist = false;
			children = new TrieNode[26]; 
		}
		
	}
	
	static class Trie{
		TrieNode rootNode;
		Trie(){ 
			rootNode = new TrieNode();
		}

		void insert(String str) {
			TrieNode cur_node = rootNode; 
			
			for(int i=0;i<str.length();i++) {
				int idx = str.charAt(i)-'a';
				if(cur_node.children[idx]==null) 
					cur_node.children[idx] = new TrieNode();
				cur_node = cur_node.children[idx]; 
			}
			cur_node.isExist= true;  
		}
		
		boolean search(String str) {
			
			TrieNode cur_node = rootNode;
			for(int i=0;i<str.length();i++) {
				int idx = str.charAt(i)-'a';
				if(cur_node.children[idx]==null) return false;
				cur_node = cur_node.children[idx];
			}
			return true;
		}
	}
}
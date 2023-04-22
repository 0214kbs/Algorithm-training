import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// trie
public class Main {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			Trie trie = new Trie();
			boolean res = true;

			int n = Integer.parseInt(br.readLine());
			String[] phones = new String[n];
			for (int i = 0; i < n; i++) {
				phones[i] = br.readLine();
			}
			for (int i = 0; i < n; i++) {
				if (!trie.insert(phones[i])) {
					res = false;
					break;
				}
			}

			if (res)
				sb.append("YES").append("\n");
			else
				sb.append("NO").append("\n");
		}
		System.out.println(sb);
	}

	// 아래부터 Trie
	static class TrieNode {
		boolean isLast = false; // 마지막 글자
		int size = 0;
		TrieNode[] children = new TrieNode[10]; // 자식노드 저장
	}

	static class Trie {
		TrieNode rootNode = new TrieNode();

		boolean insert(String str) {
			TrieNode curNode = rootNode; // 처음은 root node에서 시작

			/** 입력받은 str를 단계적으로 처리하는 for문 */
			for (int i = 0; i < str.length(); i++) {

				curNode.size++;
				int idx = str.charAt(i) - '0';

				/** 알파벳이 자식에 존재하지 않으면 */
				// 즉, 처음가본 곳이라면, 없다는 뜻 -> trie node를 설정해주기
				if (curNode.children[idx] == null)
					curNode.children[idx] = new TrieNode();

				// children을 가리키는 주소값 업데이트 (== 새로 만들었거나 존재하는 자식노드로 이동)
				curNode = curNode.children[idx];

				if (curNode.isLast)
					return false; // 동일했던 문자열이 끝나버린다? => false
			}

			// 입력받은 문자열 전체 노드를 타고 내려왔는데 자식 노드가 존재한다? => false
			if (curNode.size > 0)
				return false;

			// 마지막 자식 노드에 true 넣고 반환
			curNode.isLast = true;
			return true;
		}
	}
}

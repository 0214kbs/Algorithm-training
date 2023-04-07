import java.util.ArrayList;
import java.util.List;

class Main {
	
	private static class Node {
		int v;
		int cost;
		
		public Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
	}
	
	private static List<Node>[] list;
	private static boolean[] visited;
	private static int node, max;
	
	public static void main(String[] args) throws Exception {
		int n = read();
		
		if (n == 1) {
			System.out.print(0);
			return;
		}
		
		list = new List[n + 1];
		
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 1; i < n; i++) {
			int from = read();
			int to = read();
			int cost = read();
			
			list[from].add(new Node(to, cost));
			list[to].add(new Node(from, cost));
		}
		
		visited = new boolean[n + 1];
		dfs(1, 0);
		
		visited = new boolean[n + 1];
		dfs(node, 0);
		
		System.out.print(max);
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		return n;
	}
	
	private static void dfs(int n, int len) {
		if (len > max) {
			max = len;
			node = n;
		}
		
		visited[n] = true;
		
		for (Node next : list[n]) {
			if (visited[next.v]) {
				continue;
			}
			
			dfs(next.v, next.cost + len);
			visited[next.v] = true;
		}
	}
}

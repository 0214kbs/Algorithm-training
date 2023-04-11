import java.util.ArrayList;
import java.util.List;

class Main {
	
	private static class Heap {
		Edge[] heap;
		int size;
		
		public Heap(int size) {
			this.heap = new Edge[size + 1];
		}
		
		void offer(Edge x) {
			heap[++size] = x;
			int i = size << 1;
			
			while ((i >>= 1) > 1) {
				if (!swap(i)) {
					break;
				}
			}
		}
		
		Edge poll() {
			Edge x = heap[1];
			heap[1] = heap[size--];
			int i = 1;
			
			while ((i <<= 1) <= size) {
				if (i < size && heap[i + 1].weight < heap[i].weight) {
					i++;
				}
				
				if (!swap(i)) {
					break;
				}
			}
			
			return x;
		}
		
		boolean swap(int i) {
			int j = i >> 1;
			Edge parent = heap[j];
			Edge child = heap[i];
			
			if (parent.weight < child.weight) {
				return false;
			}
			
			heap[j] = child;
			heap[i] = parent;
			
			return true;
		}
	}
	
	private static class Edge {
		int vertex;
		int weight;
		
		public Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	
	private static final int INF = 3000000;
	
	private static List<List<Edge>> edges;
	private static int[] distance;
	private static int V, E, K;
	
	public static void main(String[] args) throws Exception {
		V = read();
		E = read();
		K = read();
		
		edges = new ArrayList<>();
		
		for (int i = 0; i <= V; i++) {
			edges.add(new ArrayList<>());
		}
		
		for (int i = 0; i < E; i++) {
			edges.get(read()).add(new Edge(read(), read()));
		}
		
		dijkstra();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= V; i++) {
			sb.append(distance[i] == INF ? "INF" : distance[i]).append('\n');
		}
		
		System.out.print(sb);
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		return n;
	}
	
	private static void dijkstra() {
		Heap pq = new Heap(E);
		boolean[] visited = new boolean[V + 1];
		distance = new int[V + 1];
		
		for (int i = 1; i <= V; i++) {
			distance[i] = INF;
		}
		
		pq.offer(new Edge(K, 0));
		distance[K] = 0;
		
		while (pq.size > 0) {
			int curr = pq.poll().vertex;
			
			if (visited[curr]) {
				continue;
			}
			
			visited[curr] = true;
			
			for (Edge next : edges.get(curr)) {
				if (distance[next.vertex] > distance[curr] + next.weight) {
					distance[next.vertex] = distance[curr] + next.weight;
					pq.offer(new Edge(next.vertex, distance[next.vertex]));
				}
			}
		}
	}
}

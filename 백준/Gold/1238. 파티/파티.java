import java.io.*;
import java.util.*;

public class Main {	
	static int n, m, x;
	static List<Node>[] adj;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[n + 1];

		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			adj[a].add(new Node(b, t));
		}
		
		int max = 0;
		for (int i = 1; i <= n; i++) {
			int goTime = dijkstra(i, x);
			int backTime = dijkstra(x, i);

			max = Math.max(max, goTime + backTime);
		}
		
		System.out.println(max);
	}

	static int dijkstra(int start, int end) {
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.w));
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node c = pq.poll();
			
			if (c.w > dist[c.to]) continue;
			if (c.to == end) return dist[c.to];
			
			for (Node v : adj[c.to]) {
				int newCost = dist[c.to] + v.w;
				if (newCost < dist[v.to]) {
					dist[v.to] = newCost;
					pq.offer(new Node(v.to, newCost));
				}
			}
		}
		
		return dist[end];
	}
}

class Node {
	int to, w;
	
	Node(int to, int w){
		this.to = to;
		this.w = w;
	}
}
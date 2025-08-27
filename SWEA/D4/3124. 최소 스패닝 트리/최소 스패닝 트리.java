import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			List<List<Edge>> adj = new ArrayList<>();

			for (int i = 0; i <= V; i++) {
				adj.add(new ArrayList<>());
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				adj.get(a).add(new Edge(b, c));
				adj.get(b).add(new Edge(a, c));
			}

			boolean[] visited = new boolean[V + 1];
			long[] minEdge = new long[V + 1];
			Arrays.fill(minEdge, Long.MAX_VALUE);

			PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingLong(e -> e.w));
			minEdge[1] = 0;
			pq.offer(new Edge(1, 0));

			long sum = 0;
			int select = 0;
			
			while(!pq.isEmpty() && select < V) {
				Edge c = pq.poll();
				int v = c.to;
				if (visited[v]) continue;
				
				visited[v] = true;
				sum += c.w;
				select++;

				for(Edge e: adj.get(v)) {
					if(!visited[e.to] && e.w < minEdge[e.to]) {
						minEdge[e.to] = e.w;
						pq.offer(new Edge(e.to, e.w));
					}
				}
			}

			System.out.printf("#%d %d%n", tc, sum);
		}
	}
}

class Edge {
	int to, w;

	Edge (int to, int w){
		this.to = to;
		this.w = w;
	}
}
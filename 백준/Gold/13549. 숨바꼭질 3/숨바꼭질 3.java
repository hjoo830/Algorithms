import java.io.*;
import java.util.*;

public class Main {	
	static int n, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		System.out.println(dijkstra());
	}

	static int dijkstra() {
		int[] dist = new int[100001];
		Arrays.fill(dist, Integer.MAX_VALUE);

		Deque<Integer> dq = new ArrayDeque<>();
		dist[n] = 0;
		dq.add(n);
		
		while(!dq.isEmpty()){
			int x = dq.pollFirst();
			if (x == k) return dist[x];

			int nx = x * 2;			
			if (nx <= 100000 && dist[nx] > dist[x]) {
				dist[nx] = dist[x];
				dq.addFirst(nx);
			}
			
			int[] nxs = {x - 1, x + 1};
			for (int nx1 : nxs) {
				if (nx1 >= 0 && nx1 <= 100000 && dist[nx1] > dist[x] + 1) {
					dist[nx1] = dist[x] + 1;
					dq.addLast(nx1);
				}
			}
		}

		return dist[k];
	}
}
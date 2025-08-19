import java.io.*;
import java.util.*;

public class Main {
	static List<List<Integer>> adj;
	static boolean[] v;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		
		for (int i = 1; i <= n; i++) {
			Collections.sort(adj.get(i));
		}
		
		v = new boolean[n + 1];
		dfs(s);
		System.out.println();
		Arrays.fill(v, false);
		bfs(s);
		
	}

	static void dfs(int s) {
		v[s] = true;
		System.out.print(s + " ");
		
		for (int nxt : adj.get(s)) {
			if (!v[nxt]) {
				dfs(nxt);
			}
		}
	}

	static void bfs(int s) {
		Queue<Integer> q = new ArrayDeque<>();
		v[s] = true;
		q.add(s);
		
		while(!q.isEmpty()) {
			int c = q.poll();
			System.out.print(c + " ");

			for (int nxt : adj.get(c)) {
				if (!v[nxt]) {
					v[nxt] = true;
					q.add(nxt);
				}
			}
		}
	}
}

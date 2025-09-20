import java.io.*;
import java.util.*;

public class Main {
	static List<Integer>[] adj;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[n + 1];
		v = new boolean[n + 1];
		
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a].add(b);
			adj[b].add(a);
		}
		
		System.out.println(bfs(1));
	}
	
	static int bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		v[start] = true;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int c = q.poll();
			
			for (int nxt : adj[c]) {
				if(!v[nxt]) {
					q.add(nxt);
					v[nxt] = true;
					cnt++;
				}
			}
		}
		
		return cnt;
	}
}

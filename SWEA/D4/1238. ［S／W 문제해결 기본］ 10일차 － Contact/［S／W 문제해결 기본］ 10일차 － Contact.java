import java.io.*;
import java.util.*;

public class Solution {
	static List<Set<Integer>> adj;
	static boolean[] v;
	static List<int[]> path;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t < 11; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 데이터의 길이
			int s = Integer.parseInt(st.nextToken()); // 시작점
			adj = new ArrayList<>();
			
			for (int i = 0; i <= 100; i++) {
				adj.add(new HashSet<>());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n/2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj.get(a).add(b);				
			}
			
			v = new boolean[101];
			path = new ArrayList<>();
			bfs(s);
			
			Collections.sort(path, (a, b) -> {
				if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
				return Integer.compare(a[1], b[1]);
			});
			
			System.out.printf("#%d %d%n", t, path.get(path.size() - 1)[1]);
		}
		
	}

	static void bfs(int s) {
		Queue<int[]> q = new ArrayDeque<>();
		v[s] = true;
		q.add(new int[] {s, 0});
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			
			for (int n : adj.get(c[0]) ) {
				if (!v[n]) {
					v[n] = true;
					q.add(new int[] {n, c[1] + 1});
					path.add(new int[] {c[1] + 1, n});
				}
			}
		}
	}
}
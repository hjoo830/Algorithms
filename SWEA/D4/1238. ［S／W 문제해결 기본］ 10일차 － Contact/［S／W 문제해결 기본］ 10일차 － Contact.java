import java.io.*;
import java.util.*;

public class Solution {
	static List<Set<Integer>> adj;
	static boolean[] v;	
	
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
			System.out.printf("#%d %d%n", t, bfs(s));
		}
	}

	static int bfs(int s) {
		Queue<int[]> q = new ArrayDeque<>();
		v[s] = true;
		q.add(new int[] {s, 0});
		
		int maxDepth = -1;
		int maxPerson = -1;
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			
			for (int n : adj.get(c[0]) ) {
				if (!v[n]) {
					v[n] = true;
					q.add(new int[] {n, c[1] + 1});
					
					if (c[1] + 1 > maxDepth) {
						maxDepth = c[1] + 1;
						maxPerson = n;
					} else if (c[1] + 1 == maxDepth) {
						maxPerson = Math.max(n, maxPerson);
					}
				}
			}
		}
		return maxPerson;
	}
}
import java.io.*;
import java.util.*;

public class Solution {
	static int[][] cost;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			cost = new int[e][3];
			
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				cost[i][0] = Integer.parseInt(st.nextToken());
				cost[i][1] = Integer.parseInt(st.nextToken());
				cost[i][2] = Integer.parseInt(st.nextToken()); // cost
			}
			
			Arrays.sort(cost, (a, b) -> a[2] - b[2]);
			
			parent = new int[v + 1];
			
			for (int i = 1; i <= v; i++) {
				parent[i] = i;
			}
			
			long sum = 0;
			for (int i = 0; i < e; i++) {
				if (union(cost[i][0], cost[i][1])) {
					sum += cost[i][2];
				}
			}
            
			System.out.printf("#%d %d%n", tc, sum);
		}
	}
	
	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa == pb) return false;
		
		if (pa < pb) parent[pb] = pa;
		else parent[pa] = pb;
		return true;
	}
}

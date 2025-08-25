import java.io.*;
import java.util.*;

public class Solution {
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			parent = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				parent[i] = i;
			}
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if (op == 0) {
					union(a, b);					
				} else if (op == 1) {
					if(find(a) == find(b)) {
						sb.append(1);
					}else {
						sb.append(0);
					}
				}
			}
			
			System.out.printf("#%d %s%n", tc, sb);
		}
	}
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa == pb) return false;
		
		if (pa < pb) parent[pb] = pa;
		else parent[pa] = pb;
		return true;
	}
	
	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
}
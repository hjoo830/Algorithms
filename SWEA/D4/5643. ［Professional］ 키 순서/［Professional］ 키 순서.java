import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			
			boolean[][] adj = new boolean[n + 1][n + 1];
			
			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				adj[a][b] = true; // a < b
			}

			for (int k = 1; k <= n; k++) {
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= n; j++) {
						if (adj[i][k] && adj[k][j]) adj[i][j] = true;
					}
				}				
			}

			int answer = 0;
			for (int i = 1; i <= n; i++) {
				int count = 0;
				for (int j = 1; j <= n; j++) {
					if (adj[i][j] || adj[j][i]) count++;
				}
				if (count == n - 1) answer++;
			}				
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t  = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			int[][] adj = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					adj[i][j] = Integer.parseInt(st.nextToken());
					if (i != j && adj[i][j] == 0) adj[i][j] = Integer.MAX_VALUE;
				}
			}
			
			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (adj[i][k] != Integer.MAX_VALUE && adj[k][j] != Integer.MAX_VALUE && 
								adj[i][j] > adj[i][k] + adj[k][j]) adj[i][j] = adj[i][k] + adj[k][j];
					}
				}
			}
			
			int answer = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int j = 0; j < n; j++) {
					sum += adj[i][j];
				}
				answer = Math.min(answer, sum);
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}	
}

import java.io.*;
import java.util.*;

public class Solution {	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[] v = new int[n]; // 부피
			int[] c = new int[n]; // 가치
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				v[i] = Integer.parseInt(st.nextToken());
				c[i] = Integer.parseInt(st.nextToken());
			}
			
			int[][] dp = new int[n + 1][k + 1];
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= k; j++) {
					if (v[i - 1] > j) dp[i][j] = dp[i - 1][j];
					else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i - 1]] + c[i - 1]);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(dp[n][k]).append("\n");
		}
		System.out.println(sb);
	}
}
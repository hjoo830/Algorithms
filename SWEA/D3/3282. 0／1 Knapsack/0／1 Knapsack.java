import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[] w = new int[n];
			int[] v = new int[n];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				w[i] = Integer.parseInt(st.nextToken());
				v[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] dp = new int[k + 1];
			for (int i = 0; i < n; i++) {
				for (int j = k; j >= w[i]; j--) {
					dp[j] = Math.max(dp[j], dp[j - w[i]]+ v[i]);				
				}
			}
			
			sb.append("#").append(tc).append(" ").append(dp[k]).append("\n");
		}
		
		System.out.println(sb);
	}
}

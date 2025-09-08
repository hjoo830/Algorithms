import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			int[] t = new int[n];
			int[] k = new int[n];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				t[i] = Integer.parseInt(st.nextToken());
				k[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] dp = new int[l + 1];
			for (int i = 0; i < n; i++) {
				for (int j = l; j >= k[i]; j--) {
					dp[j] = Math.max(dp[j], dp[j - k[i]]+ t[i]);				
				}
			}
			
			sb.append("#").append(tc).append(" ").append(dp[l]).append("\n");
		}
		
		System.out.println(sb);
	}
}
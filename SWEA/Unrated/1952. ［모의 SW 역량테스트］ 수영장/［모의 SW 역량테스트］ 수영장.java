import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			int[] day = new int[13];
			int[] price = new int[4];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < 13; i++) {
				day[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] dp = new int[13];
			
			dp[1] = Math.min(day[1] * price[0], price[1]);
			dp[2] = dp[1] + Math.min(day[2] * price[0], price[1]);
			
			for (int i = 3; i < 13; i++) {
				dp[i] = Math.min(Math.min(dp[i - 1] + day[i] * price[0], dp[i - 1] + price[1]), dp[i - 3] + price[2]);
			}
			
			sb.append("#").append(tc).append(" ").append(Math.min(dp[12], price[3])).append("\n");
		}
		
		System.out.println(sb);
	}
}
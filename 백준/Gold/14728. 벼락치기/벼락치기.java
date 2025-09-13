import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		int[] k = new int[n + 1];
		int[] s = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			k[i] = Integer.parseInt(st.nextToken());
			s[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[n + 1][t + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= t; j++) {
				if (k[i] > j) dp[i][j] = dp[i - 1][j];
				else dp[i][j] = Math.max(dp[i - 1][j], dp[i- 1][j - k[i]] + s[i]);
			}
		}
		
		System.out.println(dp[n][t]);
	}
}
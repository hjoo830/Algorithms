import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] dp = new int[arr.length];
			dp[0] = arr[0]; 
			int idx = 0; 
			
			for (int i = 1; i < arr.length; i++) { 
				if (dp[idx] <= arr[i]) { 
					dp[++idx] = arr[i]; 
				} else { 
					int ii = lower_bound(dp, idx, arr[i]);
					dp[ii] = arr[i];
				}
			}
			
			sb.append("#").append(tc).append(" ").append(idx + 1).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int lower_bound(int[] dp, int end, int n) {
		int start = 0;

		while (start < end) {
			int mid = (start + end) / 2;
			if (dp[mid] >= n) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return end;
	}
}
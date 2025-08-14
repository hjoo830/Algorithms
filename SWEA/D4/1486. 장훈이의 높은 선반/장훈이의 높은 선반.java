import java.io.*;
import java.util.*;

public class Solution {
	static int n, b;
	static int[] h;
	static Set<Integer> tops = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			h = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				h[i] = Integer.parseInt(st.nextToken());
			}
			
			tops.clear(); 
			bt(0, 0);
			
			int minTop = Integer.MAX_VALUE;
			for (int top : tops) {
				minTop = Math.min(minTop, top);
			}
			
			System.out.printf("#%d %d%n", tc, minTop - b);
		}	
	}
	
	static void bt(int idx, int sum) {
		if(idx == n) {
			if(sum >= b) {
				tops.add(sum);
			}
			return;			
		}
		
		bt(idx + 1, sum + h[idx]);
		bt(idx + 1, sum);
	}
}

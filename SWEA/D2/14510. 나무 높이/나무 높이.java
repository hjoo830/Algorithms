import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] tree = new int[n];
            int goal = 0;
            for (int i = 0; i < n; i++) {
                tree[i] = Integer.parseInt(st.nextToken());
                goal = Math.max(goal, tree[i]);
            }

            int odd = 0;
    		int even = 0;
    		for (int h : tree) {
    			odd += (goal - h) % 2;
    			even += (goal - h) / 2;
    		}
            
    		if (even > odd) {
    			while (Math.abs(even - odd) > 1) {
    				even--;
    				odd += 2;
    			}
    		}
            
    		int answer = 0;
    		if(even > odd) {
    			answer = 2 * even;
    		} else if (even < odd) {
    			answer = 2 * odd - 1;
    		} else {
    			answer = odd + even;
    		}
            System.out.printf("#%d %d%n", tc, answer);
        }		
	}
}
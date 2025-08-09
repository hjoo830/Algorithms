import java.io.*;
import java.util.*;

public class Main {
	static int[][] ingredient;
	static int minDiff;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		ingredient = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ingredient[i][0] = Integer.parseInt(st.nextToken());
			ingredient[i][1] = Integer.parseInt(st.nextToken());
		}
		
		minDiff = Integer.MAX_VALUE;
		
		cook(0, 1, 0, 0);
		
		System.out.println(minDiff);
	}
	
	static void cook(int idx, int s, int b, int use) {
		if(idx == ingredient.length) {
			if(use == 0) {
				return;
			}
			minDiff = Math.min(minDiff, Math.abs(s - b));
			return;
		}
		
		cook(idx + 1, s * ingredient[idx][0], b + ingredient[idx][1], use + 1);
		cook(idx + 1, s, b, use);
	}
}
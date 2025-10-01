import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
          
			int[] score = new int[n];
			int sum = 0;
			for (int i = 0; i < n; i++) {
				score[i] = Integer.parseInt(st.nextToken());
				sum += score[i];
			}

			double cnt = 0;
			double avg = sum / n;
			for (int s : score) {
				if (s > avg) cnt++;
			}

			double ratio = cnt / n * 100;
			sb.append(Math.round(ratio * 1000) / 1000.0).append("%").append("\n");
		}
		
		System.out.println(sb);
	}
}

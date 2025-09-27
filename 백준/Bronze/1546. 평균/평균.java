import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] score = new int[n];
		int max = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			score[i] = Integer.parseInt(st.nextToken());
			if (max < score[i]) max = score[i];
		}
		
		double sum = 0;
		for (int i = 0; i < n; i++) {
			sum += (double)score[i] / (double)max * 100;
		}
		
		System.out.println(sum / n);
	}
}
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int room = 12;

		int[][] students = new int[7][2];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			students[y][s]++;
		}
		
		for (int i = 1; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				if (students[i][j] == 0) {
					room--;
				}
				if (students[i][j] > k) {
					room += students[i][j] / k;
				}
			}
		}

		System.out.println(room);
	}
}

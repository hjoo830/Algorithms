import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] plate = new int[n];
		for (int i = 0; i < n; i++) {
			plate[i] = Integer.parseInt(br.readLine());
		}
		
		int[] cnt = new int[d + 1];
        int kinds = 0;

        for (int i = 0; i < k; i++) {
            if (cnt[plate[i]] == 0) kinds++;
            cnt[plate[i]]++;
        }

        int max = kinds + (cnt[c] == 0 ? 1 : 0);

        for (int start = 1; start < n; start++) {
            int left = plate[start - 1];
            cnt[left]--;
            if (cnt[left] == 0) kinds--;

            int right = plate[(start + k - 1) % n];
            if (cnt[right] == 0) kinds++;
            cnt[right]++;

            int cur = kinds + (cnt[c] == 0 ? 1 : 0);
            if (cur > max) max = cur;
        }

        System.out.println(max);
	}
}
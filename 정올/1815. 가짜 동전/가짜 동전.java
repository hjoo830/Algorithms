import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		List<Integer> coin = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			coin.add(i);
		}

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int[] left = new int[c];
			int[] right = new int[c];
			boolean[] onScale = new boolean[n + 1];

			for (int j = 0; j < c; j++) {
				left[j] = Integer.parseInt(st.nextToken());
				onScale[left[j]] = true;
			}
			for (int j = 0; j < c; j++) {
				right[j] = Integer.parseInt(st.nextToken());
				onScale[right[j]] = true;
			}

			String op = br.readLine();
			if (op.equals("=")) {
				for (int j = 0; j < c; j++) {
					coin.remove(Integer.valueOf(left[j]));
					coin.remove(Integer.valueOf(right[j]));
				}
			} else {
				Set<Integer> candidate = new HashSet<>();

				for (int j = 0; j < c; j++) {
					candidate.add(left[j]);
					candidate.add(right[j]);
				}

				for (int j = 1; j <= n; j++) {
					if (!onScale[j]) candidate.remove(j);
				}

				coin.retainAll(candidate);
			}
		}

		int answer = 0;
		if (coin.size() == 1) answer = coin.get(0);
		System.out.println(answer);
	}
}

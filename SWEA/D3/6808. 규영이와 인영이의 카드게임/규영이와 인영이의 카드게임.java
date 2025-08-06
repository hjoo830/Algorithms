import java.io.*;
import java.util.*;

public class Solution {
	static int win = 0;
	static int lose = 0;
	static boolean[] v = new boolean[9];
	static List<Integer> cardsG, cardsI;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cardsI = new ArrayList<>();
			for(int i = 1; i <= 18; i++) {
				cardsI.add(i);
			}
			
			cardsG = new ArrayList<>();
			for(int i = 0; i < 9; i++) {
				cardsG.add(Integer.parseInt(st.nextToken()));
			}
			
			cardsI.removeAll(cardsG);
			
			win = 0;
			lose = 0;
			Arrays.fill(v, false);
			
			dfs(0, 0, 0);
			 
			System.out.printf("#%d %d %d%n", tc, win, lose);
		}
	}

	static void dfs(int cnt, int scoreG, int scoreI) {
		if (cnt == 9) {
			if (scoreG > scoreI) {
				win++;
			} else if (scoreG < scoreI) {
				lose++;
			}
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if (!v[i]) {
				v[i] = true;
				int g = cardsG.get(cnt);
				int iy = cardsI.get(i);
				
				if (g > iy) {
					dfs(cnt + 1, scoreG + g + iy, scoreI);
				} else {
					dfs(cnt + 1, scoreG, scoreI + g + iy);
				}
				v[i] = false;
			}
		}
	}
}
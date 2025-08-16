import java.io.*;
import java.util.*;

public class Solution {
	static int n, k, max, answer;
	static int[][] map;
	static boolean[][] v;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	n = Integer.parseInt(st.nextToken());
        	k = Integer.parseInt(st.nextToken());
            
        	map = new int[n][n];
        	max = 0;
        	answer = 0;
            for (int i = 0; i < n; i++) {
            	st = new StringTokenizer(br.readLine());
            	for (int j = 0; j < n; j++) {
            		map[i][j] = Integer.parseInt(st.nextToken());
            		max = Math.max(max, map[i][j]);
            	}
            }
            
            for (int i = 0; i < n; i++) {
            	for (int j = 0; j < n; j++) {
            		if(max == map[i][j]) {
            			v = new boolean[n][n];
            			dfs(i, j, 1, false);
            		}
            	}
            }
            
            System.out.printf("#%d %d%n", tc, answer);
        }
		
	}
	static void dfs(int x, int y, int len, boolean flag) {
		v[x][y] = true;
		answer = Math.max(answer, len);
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (nx >= 0 && nx < n && ny >= 0 && ny < n && !v[nx][ny]) {
				if(map[nx][ny] < map[x][y]) { // 더 낮은 지형이면
					dfs(nx, ny, len + 1, flag);
				} else if (!flag && map[nx][ny] - k < map[x][y]) { // 깎아서 더 낮으면
					int temp = map[nx][ny]; // 깎기 전
					map[nx][ny] = map[x][y] - 1;
					dfs(nx, ny, len + 1, true);
					map[nx][ny] = temp; // 복원
				}
			}
		}
		v[x][y] = false;
	}
}
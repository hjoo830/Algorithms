import java.io.*;
import java.util.*;

public class Solution {
	static int n;
	static int[][] grid;
	static List<int[]> cores;
	static int maxConnected, minLen;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			
			grid = new int[n][n];
			cores = new ArrayList<>();
			maxConnected = 0;
			minLen = Integer.MAX_VALUE;

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
					if (grid[i][j] == 1 && i != 0 && i != n - 1 && j != 0 && j != n -1) {// 이미 연결된 가장자리 코어 제외
						cores.add(new int[] {i, j});
					}
				}
			}
			
			dfs(0, 0, 0);
			
			System.out.printf("#%d %d%n", tc, minLen);
		}
		
	}
	
	static void dfs(int idx, int connected, int len) {
		if (connected + (cores.size() - idx) < maxConnected) return; // 남은 코어를 전부 연결해도 최대 연결 수를 넘지 못하면 중단

		if (idx == cores.size()) {
			if (connected > maxConnected) {
				maxConnected = connected;
				minLen = len;
			} else if (connected == maxConnected) {
				minLen = Math.min(minLen, len);
			}
			return;
		}
		
		int x = cores.get(idx)[0];
		int y = cores.get(idx)[1];
		
		for (int d = 0; d < 4; d++) {
			if(!can(x, y, d)) continue;
			int add = setWire(x, y, d, 2); // 전선 설치
			dfs(idx + 1, connected + 1, len + add);
			setWire(x, y, d, 0); // 전선 제거
		}
		
        dfs(idx + 1, connected, len); // 이 코어를 연결하지 않는 경우
	}
	
	static boolean can(int x, int y, int d) {
		int nx = x, ny = y;
		
        while (true) {
            nx += dx[d];
            ny += dy[d];
            
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) break; // 가장자리에 닿으면 연결 됨
            if (grid[nx][ny] != 0) return false;               // 코어(1)나 전선(2) 만나면 불가
        }
        return true;
	}

	static int setWire(int x, int y, int d, int val) {
        int nx = x, ny = y, cnt = 0;
        
        while (true) {
            nx += dx[d];
            ny += dy[d];
            
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) break; // 가장자리 도달하면 종료
            grid[nx][ny] = val; // 2: 전선 깔기 // 0: 전선 제거
            cnt++;
        }
        return cnt; // 깐 전선 길이
    }
}
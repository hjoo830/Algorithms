import java.io.*;
import java.util.*;

public class Solution {
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static int N, W, H, min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= t; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int[][] map = new int[H][W];

			for (int r = 0; r < H; ++r) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; ++c) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}			
			min = Integer.MAX_VALUE;
			drop(0, map);
			System.out.println("#" + tc + " "+min);
		}

	}

	private static boolean drop(int count, int[][] map) { 
		int remainCnt = getRemain(map);
		if(remainCnt == 0) {
			min = 0;
			return true;
		}
		if(count == N) {
			min = Math.min(min, remainCnt);
			return false;
		}

		int[][] newMap = new int[H][W];

		for (int c = 0; c < W; c++) {
			int r = 0;
			while(r < H && map[r][c] == 0) ++r;
			if(r == H) continue;

			copy(map, newMap);
			boom(newMap, r, c);
			down(newMap);
			if(drop(count+1, newMap)) return true;
		}
		return false;
	}

	private static int getRemain(int[][] map) {
		int count = 0;
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				if(map[r][c] > 0) ++count;
			}
		}
		return count;
	}

	static Stack<Integer> stack = new Stack<>();
	private static void down(int[][] map) {
		for (int c = 0; c < W; c++) {
			for (int r = 0; r < H; r++) {
				if(map[r][c] == 0) continue;
				stack.push(map[r][c]);
				map[r][c]=0;
			}

			int r = H - 1;
			while(!stack.isEmpty()) {
				map[r--][c] = stack.pop();
			}
		}
	}

	private static void boom(int[][] map, int r, int c) {
		Queue<Point> queue = new ArrayDeque<>();
		if(map[r][c] > 1) {
			queue.offer(new Point(r, c, map[r][c]));
		}
		map[r][c] = 0;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur.r, nc = cur.c;
				for (int k = 1; k < cur.cnt; k++) {
					nr += dr[d];
					nc += dc[d];
					if(nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != 0) {
						if(map[nr][nc]>1) {
							queue.offer(new Point(nr, nc, map[nr][nc]));
						}
						map[nr][nc] = 0;
					}
				}
			}
		}
	}

	private static void copy(int[][] map, int[][] newMap) {
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				newMap[r][c] = map[r][c];
			}
		}
	}

}

class Point{
	int r, c, cnt;

	public Point(int r, int c,int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}
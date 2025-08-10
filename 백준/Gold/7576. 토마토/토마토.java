import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] grid;
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		grid = new int[n][m];
		v = new boolean[n][m];

		Queue<Point> q = new ArrayDeque<>();

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if (grid[i][j] == 1) {
					q.add(new Point(i, j));
					v[i][j] = true;
				}
			}
		}

		int day = -1;
		while(!q.isEmpty()) {
			day++;
			int size = q.size();

			for(int i = 0; i < size; i++) {
				Point c = q.remove();

				for (int d = 0; d < 4; d++) {
					int nx = c.x + dx[d];
					int ny = c.y + dy[d];

					if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
						if(!v[nx][ny] && grid[nx][ny] == 0) {
							v[nx][ny] = true;
							q.add(new Point(nx, ny));
							grid[nx][ny] = 1;
						}
					}
				}
			}
		}

		for(int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(day);
	}
}

class Point {
	int x, y;

	Point(int x, int y){
		this.x = x;
		this.y = y;		
	}
}
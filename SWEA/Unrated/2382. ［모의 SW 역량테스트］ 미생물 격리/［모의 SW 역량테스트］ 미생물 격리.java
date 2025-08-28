import java.io.*;
import java.util.*;

public class Solution {
	static int n, m, k;
	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, -1, 1};
	static Micro[] list;
	static Micro[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			list = new Micro[k];
			map = new Micro[n][n];

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				list[i] = new Micro(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			sb.append("#").append(tc).append(" ").append(move()).append("\n");
		}
		System.out.println(sb);
	}

	private static int move() { // 살아 있는 미생물 수 리턴

		int time = m, nr, nc, remainCnt=0;
		while (time-- > 0) {
			for (Micro cur: list) {
				if (cur.isDead) continue; // 리스트에서 삭제하지 않았으므로 건너뛰도록 처리 필요

				// 한칸 이동
				nr = cur.r += dr[cur.dir];
				nc = cur.c += dc[cur.dir];

				// 약품 칸 처리
				if (nr == 0 || nr == n - 1 || nc == 0 || nc == n - 1) {
					// 군집의 크기 절반으로 줄이고 방향 바꿈, 크기가 0이면 소멸
					cur.total = cur.cnt = cur.cnt/2;
					if(cur.cnt == 0){
						cur.isDead = true;
						continue;
					}
					// 방향 반대로
					if(cur.dir % 2 == 1) cur.dir++;
					else cur.dir--;
				}

				// 군집 병합 관련 처리
				if (map[nr][nc] == null) { // 그 셀에 처음 도착하는 군집
					map[nr][nc] = cur;
				} else {// 그 셀에 나중에 도착하는 군집(이미 다른 군집이 있는 경우)
					// 군집의 미생물 크기로 비교해서 큰쪽으로 흡수시키고 작은 크기의 군집은 소멸
					if(map[nr][nc].cnt > cur.cnt) {
						map[nr][nc].total += cur.cnt;
						cur.isDead = true;
					}else { // 나중에 도착한 군집의 크기가 크면
						cur.total += map[nr][nc].total;
						map[nr][nc].isDead = true;
						map[nr][nc] = cur;
					}
				}
			}

			remainCnt = reset();
		}

		return remainCnt;
	}

	private static int reset() { 
		int total = 0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if(map[r][c] == null) continue;
				// 군집이 있다면 정리
				map[r][c].cnt = map[r][c].total;
				total += map[r][c].cnt;
				map[r][c] = null;
			}
		}
		return total;
	}
}

class Micro{
	int r, c, cnt, dir, total;
	boolean isDead;

	public Micro(int r, int c, int cnt, int dir) {
		super();
		this.r = r;
		this.c = c;
		this.total = this.cnt = cnt;
		this.dir = dir;
	}
}
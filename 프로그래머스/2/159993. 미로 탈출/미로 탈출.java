import java.util.*;

class Solution {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int n, m;
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        int sr, sc, lr, lc, er, ec;
        sr = sc = lr = lc = er = ec = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'S') {
                    sr = i;
                    sc = j;
                } else if (maps[i].charAt(j) == 'L') {
                    lr = i;
                    lc = j;
                } else if (maps[i].charAt(j) == 'E') {
                    er = i;
                    ec = j;
                }
            }
        }

        int t1 = bfs(maps, sr, sc, lr, lc);
        if (t1 == -1) return -1;
        
        int t2 = bfs(maps, lr, lc, er, ec);
        if (t2 == -1) return -1;
        
        return t1 + t2;
    }
    
    int bfs(String[] maps, int r1, int c1, int r2, int c2) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] v = new boolean[n][m];
        q.offer(new int[] {r1, c1, 0});
        v[r1][c1] = true;
        
        while (!q.isEmpty()) {
            int[] c = q.poll();
            
            if (c[0] == r2 && c[1] == c2) return c[2];
            
            for (int d = 0; d < 4; d++) {
                int nr = c[0] + dr[d];
                int nc = c[1] + dc[d];
                
                if (nr >= n || nr < 0 || nc >= m || nc < 0) continue;
                if (!v[nr][nc] && maps[nr].charAt(nc) != 'X') {
                    q.offer(new int[] {nr, nc, c[2] + 1});
                    v[nr][nc] = true;
                }
            }
        }
        
        return -1;
    }
}
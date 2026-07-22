import java.util.*;

class Solution {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int n, m;
    
    public int solution(String[] board) {
        int answer = 0;
        n = board.length;
        m = board[0].length();
        int sr = 0, sc = 0, er = 0, ec = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    sr = i;
                    sc = j;
                } else if (board[i].charAt(j) == 'G') {
                    er = i;
                    ec = j;
                }
            }
        }
        
        return bfs(board, sr, sc, er, ec);
    }
    
    int bfs(String[] board, int sr, int sc, int er, int ec) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] v = new boolean[n][m];
        q.offer(new int[] {sr, sc, 0});
        v[sr][sc] = true;
        
        while (!q.isEmpty()) {
            int[] c = q.poll();
            
            if (c[0] == er && c[1] == ec) return c[2];
            
            for (int d = 0; d < 4; d++) {
                int nr = c[0];
                int nc = c[1];
                while (true) {
                    int nextRow = nr + dr[d];
                    int nextCol = nc + dc[d];
                    
                    if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) break;
                    if (board[nr + dr[d]].charAt(nc + dc[d]) == 'D') break;
                    
                    nr = nextRow;
                    nc = nextCol;  
                }
                
                if (!v[nr][nc]) {
                    q.offer(new int[] {nr, nc, c[2] + 1});
                    v[nr][nc] = true;
                }
                
            }
        }
        
        return -1;
    }
}
import java.util.*;

class Solution {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int n, m;
    static int[][] label;
    static int cnt = 1;
    
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        
        List<Integer> areas = new ArrayList<>();
        areas.add(0);
        label = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (label[i][j] == 0 && land[i][j] == 1) {
                    areas.add(bfs(i, j, land));
                    cnt++;
                }
            }
        }

        for (int c = 0; c < m; c++) {
            Set<Integer> set = new HashSet<>();

            for (int r = 0; r < n; r++) {
                if (label[r][c] != 0) {
                    set.add(label[r][c]);
                }
            }
            
            int sum = 0;
            for (int num : set) {
                sum += areas.get(num);
            }
            
            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
    
    int bfs(int sr, int sc, int[][] land) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {sr, sc});
        label[sr][sc] = cnt;
        int area = 0;
        
        while(!q.isEmpty()) {
            int[] c = q.poll();
            area++;
            
            for (int d = 0; d < 4; d++) {
                int nr = c[0] + dr[d];
                int nc = c[1] + dc[d];
                
                if (nr >= n || nr < 0 || nc >= m || nc < 0) continue;
                if (label[nr][nc] == 0 && land[nr][nc] == 1) {
                    label[nr][nc] = cnt;
                    q.offer(new int[] {nr, nc});
                }
            }
        }
        
        return area;
    }
}
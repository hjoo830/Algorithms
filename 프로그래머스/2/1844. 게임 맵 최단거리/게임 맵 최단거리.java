import java.util.*;

// (0, 0) -> (n - 1, m - 1) 최단거리 구하는 문제. 0은 벽 1은 길
class Solution {
    static int n, m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] v;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        v = new boolean[n][m];
        
        return bfs(maps);
    }
    
    private int bfs(int[][] maps) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(0, 0, 1));
        v[0][0] = true;
        
        while (!q.isEmpty()) {
            Point c = q.poll();
            
            for (int d = 0; d < 4; d++) {
                int nx = c.x + dx[d];
                int ny = c.y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || maps[nx][ny] == 0) continue; 
                if (nx == n - 1 && ny == m - 1) return c.dist + 1;
                    
                if (!v[nx][ny]) {
                    v[nx][ny] = true;
                    q.add(new Point(nx, ny, c.dist + 1));
                }
            }
        }
        
        return -1;
    }
}

class Point {
    int x, y, dist;
    
    Point(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
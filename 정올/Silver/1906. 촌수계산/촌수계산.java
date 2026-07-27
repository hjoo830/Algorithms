import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<Integer>[] graph;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int person1 = Integer.parseInt(st.nextToken());
        int person2 = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        v = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        System.out.println(bfs(person1, person2));
    }

    static int bfs(int s, int e) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {s, 0});
        v[s] = true;

        while(!q.isEmpty()) {
            int[] c =  q.poll();

            if (c[0] == e) return c[1];

            for (int next : graph[c[0]]) {
                if (!v[next]) {
                    q.offer(new int[] {next, c[1] + 1});
                    v[next] = true;
                }
            }
        }

        return -1;
    }
}
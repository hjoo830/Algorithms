import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Integer>[] graph;
    static boolean[] v;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        v = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        dfs(1);
        System.out.println(sb);
    }

    static void dfs(int now) {
        v[now] = true;
        sb.append(now).append(' ');

        for (int next : graph[now]) {
            if (!v[next]) {
                dfs(next);
            }
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static Node[] nodes;
    static boolean[] v;
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        nodes = new Node[n + 1];
        v = new boolean[n + 1];
        adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            nodes[i] = new Node(0, 0);
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        bfs();

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(lca(a, b)).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        v[1] = true;
        nodes[1].parent = 0;
        nodes[1].depth = 0;

        while (!q.isEmpty()) {
            int c = q.poll();

            for (int nxt : adj[c]) {
                if(!v[nxt]) {
                    q.add(nxt);
                    v[nxt] = true;
                    nodes[nxt].parent = c;
                    nodes[nxt].depth = nodes[c].depth + 1;
                }
            }
        }
    }

    static int lca(int a, int b) {
        if (nodes[a].depth > nodes[b].depth) {
            int temp = b;
            b = a;
            a = temp;
        }

        while (nodes[a].depth != nodes[b].depth) {
            b = nodes[b].parent;
        }

        while (a != b) {
            a = nodes[a].parent;
            b = nodes[b].parent;
        }

        return a;
    }
}

class Node {
    int parent, depth;

    public Node(int parent, int depth) {
        this.parent = parent;
        this.depth = depth;
    }
}
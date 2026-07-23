import java.util.*;

class Solution {
    static List<Node>[] adj;

    public int networkDelayTime(int[][] times, int n, int k) {
        adj = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] time : times) {
            adj[time[0]].add(new Node(time[1], time[2]));
        }

        return dijkstra(k, n);
    }

    int dijkstra(int s, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.w));
        pq.offer(new Node(s, 0));

        while(!pq.isEmpty()) {
            Node c = pq.poll();

            if (c.w > dist[c.to]) continue;

            for (Node v : adj[c.to]) {
                int newWeight = c.w + v.w;
                if (newWeight < dist[v.to]) {
                    dist[v.to] = newWeight;
                    pq.offer(new Node(v.to, newWeight));
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i]);
        }

        return max == Integer.MAX_VALUE ? -1 : max;
    }
}

class Node {
    int to, w;

    Node(int to, int w) {
        this.to = to;
        this.w = w;
    }
}
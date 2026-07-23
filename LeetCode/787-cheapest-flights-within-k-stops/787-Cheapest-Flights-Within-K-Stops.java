import java.util.*;

class Solution {
    static List<Node>[] adj;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            adj[flight[0]].add(new Node(flight[1], flight[2]));
        }

        int price = dijkstra(src, dst, k, n);
        if (price == Integer.MAX_VALUE) price = -1;
        return price;
    }

    int dijkstra(int s, int e, int k, int n) {
        int[][] dist = new int[n][k + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[s][0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.w));
        pq.offer(new Node(s, 0, 0));

        while (!pq.isEmpty()) {
            Node c = pq.poll();

            if (c.w > dist[c.to][c.cnt]) continue;
            if (c.cnt == k + 1) continue;
            
            for (Node v : adj[c.to]) {
                int newWeight = c.w + v.w;
                int newCnt = c.cnt + 1;

                if (newWeight < dist[v.to][newCnt]) {
                    dist[v.to][newCnt] = newWeight;
                    pq.offer(new Node(v.to, newWeight, newCnt));
                }
            }
        }
        
        int result = Integer.MAX_VALUE;
        for (int cnt = 0; cnt <= k + 1; cnt++) {
            result = Math.min(result, dist[e][cnt]);
        }

        return result;
    }
}

class Node {
    int to, w, cnt;

    Node(int to, int w) {
        this.to = to;
        this.w = w;
    }

    Node(int to, int w, int cnt) {
        this.to = to;
        this.w = w;
        this.cnt = cnt;
    }
}
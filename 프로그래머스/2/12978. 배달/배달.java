import java.util.*;

class Solution {
    static List<List<Node>> adj = new ArrayList<>();
    
    public int solution(int N, int[][] road, int K) {
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] node : road) {
            adj.get(node[0]).add(new Node(node[1], node[2]));
            adj.get(node[1]).add(new Node(node[0], node[2]));
        }
        
        int[] result = dijkstra(N);
        int answer = 0;
        for (int d : result) {
            if (d <= K) answer++;
        }
        
        return answer;
    }
    
    private int[] dijkstra(int N) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.w));
        pq.add(new Node(1, 0));
        
        while (!pq.isEmpty()) {
            Node c = pq.poll();
            
            if (c.w > dist[c.to]) continue;
            
            for (Node v : adj.get(c.to)) {
                int newWeight = c.w + v.w;
                if (newWeight < dist[v.to]) {
                    dist[v.to] = newWeight;
                    pq.add(new Node(v.to, newWeight));
                }
            }
        }
        
        
        return dist;
    }
}

class Node {
    int to, w;
    
    Node(int to, int w) {
        this.to = to;
        this.w = w;
    }
}
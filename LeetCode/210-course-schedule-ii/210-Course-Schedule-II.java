import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static int[] inD;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        inD = new int[numCourses];
        int[] answer = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int to = prerequisites[i][0];
            int from = prerequisites[i][1];
            graph[from].add(to);
            inD[to]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inD[i] == 0) q.offer(i);
        }

        int idx = 0;
        while(!q.isEmpty()) {
            int c = q.poll();
            answer[idx++] = c;

            for (int i : graph[c]) {
                inD[i]--;
                if (inD[i] == 0) {
                    q.offer(i);
                }
            }
        }

        if (idx != numCourses) return new int[0];

        return answer;
    }
}
import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] inD = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            int to = prerequisite[0];
            int from = prerequisite[1];
            graph[from].add(to);
            inD[to]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inD[i] == 0) q.offer(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            for (int next : graph[node]) {
                inD[next]--;

                if (inD[next] == 0) {
                    q.offer(next);
                }
            }
        }

        return count == numCourses;
    }
}
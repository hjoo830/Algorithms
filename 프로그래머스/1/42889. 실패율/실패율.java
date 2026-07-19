import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Double> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            int total = 0;
            int fail = 0;

            for (int userStage : stages) {
                if (userStage >= i) total++;
                if (userStage == i) fail++;
            }

            double rate = total == 0 ? 0.0 : (double) fail / total;
            map.put(i, rate);
        }

        List<Integer> stageNumbers = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            stageNumbers.add(i);
        }

        stageNumbers.sort((a, b) -> {
            if (map.get(a).equals(map.get(b))) return a - b;
            return Double.compare(map.get(b), map.get(a));
        });

        for (int i = 0; i < N; i++) {
            answer[i] = stageNumbers.get(i);
        }

        return answer;
    }
}
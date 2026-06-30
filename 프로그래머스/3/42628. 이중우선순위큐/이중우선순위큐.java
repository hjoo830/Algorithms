import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((i1, i2) -> i2 - i1);
        
        for (int i = 0; i < operations.length; i++) {
            String commands[] = operations[i].split(" ");
            if (commands[0].equals("I")) {
                minQueue.add(Integer.parseInt(commands[1]));
                maxQueue.add(Integer.parseInt(commands[1]));
            } else if (!minQueue.isEmpty() && !maxQueue.isEmpty()) {
                if (Integer.parseInt(commands[1]) == 1) minQueue.remove(maxQueue.poll());
                else maxQueue.remove(minQueue.poll());
            }
        }
        
        if (!minQueue.isEmpty() && !maxQueue.isEmpty()) {
            answer[0] = maxQueue.poll();
            answer[1] = minQueue.poll();
        }
        return answer;
    }
}
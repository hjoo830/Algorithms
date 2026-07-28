import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < 2 * n; i++) {
            int current = i % n;

            while (!stack.isEmpty() && nums[stack.peek()] < nums[current]) {
                answer[stack.pop()] = nums[current];
            }

            if (i < n) stack.push(current);
        }

        return answer;
    }
}
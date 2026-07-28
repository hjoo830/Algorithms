import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        for (int i = 0; i < n; i++) {
            for (int step = 1; step < n; step++) {
                int j = (i + step) % n;

                if (nums[i] < nums[j]) {
                    answer[i] = nums[j];
                    break;
                }
            }
        }

        return answer;
    }
}
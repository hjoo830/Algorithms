class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) return false;

        // dp[i] = 지금까지 확인한 숫자들로 합 i를 만들 수 있는가?
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;

        for (int i = 0; i < nums.length; i++) {
            for (int j = sum / 2; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }

        return dp[sum / 2];
    }
}
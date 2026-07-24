class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] dp1 = new int[n]; // 첫번째 ~ n - 1번째 집 방문
        int[] dp2 = new int[n]; // 두번째 ~ n번째 집 방문
        
        dp1[0] = nums[0];
        dp1[1] = nums[0];
        dp2[1] = nums[1];
        
        for (int i = 2; i < n; i++) {
            if (i < n - 1) {
                dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
            }
            dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
        }

        return Math.max(dp1[n - 2], dp2[n - 1]);
    }
}
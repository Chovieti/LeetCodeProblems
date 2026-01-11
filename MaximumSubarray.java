public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 1], Math.max(nums[i], Integer.MIN_VALUE));
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

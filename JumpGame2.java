public class JumpGame2 {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) dp[i] = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i] && (i + j) < nums.length; j++) {
                dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
            }
        }
        return dp[nums.length - 1];
    }
}

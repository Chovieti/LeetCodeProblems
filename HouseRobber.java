public class HouseRobber {
    public int rob(int[] nums) {
        int l = nums.length;
        int[] dp = new int[l + 1];
        for (int i = 0; i < l; i++) {
            int prev1 = 0, prev2 = 0;
            if (i - 1 > 0) prev1 = dp[i - 1];
            if (i - 2 > 0) prev2 = dp[i - 2];
            dp[i + 1] = Math.max(prev1, prev2) + nums[i];
        }
        return Math.max(dp[l], dp[l - 1]);
    }
}

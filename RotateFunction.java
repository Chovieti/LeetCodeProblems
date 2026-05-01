public class RotateFunction {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int pref = 0;
        for (int i = 0; i < n; i++) {
            dp[0] += nums[i] * i;
            pref += nums[i];
        }
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + pref - (nums[n - i] * n);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

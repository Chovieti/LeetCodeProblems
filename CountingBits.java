public class CountingBits {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        if (n > 0) dp[1] = 1;
        for (int i = 2, point = 1; i <= n; i++) {
            if (i == point * 2) {
                dp[i] = 1;
                point = i;
            } else {
                dp[i] = 1 + dp[i - point];
            }
        }
        return dp;
    }
}

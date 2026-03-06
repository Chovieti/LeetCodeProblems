import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        Arrays.fill(dp[0], Integer.MIN_VALUE);
        for (int i = 1; i <= m; i++) dp[i][0] = Integer.MIN_VALUE;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], 0) + Math.max(dp[i][j - 1], 0);
            }
        }
        return dp[m][n];
    }
}

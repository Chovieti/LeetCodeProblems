public class MaximumNonNegativeProductInAMatrix {
    record Pair(long min, long max) {}
    public int maxProductPath(int[][] grid) {
        if (grid[0][0] == 0) return 0;

        int n = grid.length;
        int m = grid[0].length;
        Pair[][] dp = new Pair[n][m];
        dp[0][0] = new Pair(grid[0][0], grid[0][0]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) continue;
                long max = Math.max(
                        i - 1 < 0 ? Long.MIN_VALUE : dp[i - 1][j].max,
                        j - 1 < 0 ? Long.MIN_VALUE : dp[i][j - 1].max
                );
                long min = Math.min(
                        i - 1 < 0 ? Long.MAX_VALUE : dp[i - 1][j].min,
                        j - 1 < 0 ? Long.MAX_VALUE : dp[i][j - 1].min
                );
                if (grid[i][j] < 0) {
                    dp[i][j] = new Pair(max * grid[i][j], min * grid[i][j]);
                } else {
                    dp[i][j] = new Pair(min * grid[i][j], max * grid[i][j]);
                }
            }
        }
        if (dp[n - 1][m - 1].max < 0 && dp[n - 1][m - 1].min < 0) return -1;
        return (int) (Math.max(dp[n - 1][m - 1].max, dp[n - 1][m - 1].min) % (1e9 + 7));
    }
}

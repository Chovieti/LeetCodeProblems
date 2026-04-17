public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n][m];
        int res = 0;
        for (int i = 0; i < n; i++) {
            char a = text1.charAt(i);
            for (int j = 0; j < m; j++) {
                char b = text2.charAt(j);
                int top = (i == 0) ? 0 : dp[i - 1][j];
                int diag = (i == 0 || j == 0) ? 0 : dp[i - 1][j - 1];
                int left = (j == 0) ? 0 : dp[i][j - 1];
                if (a == b) {
                    dp[i][j] = diag + 1;
                } else {
                    dp[i][j] = Math.max(diag, Math.max(top, left));
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return res;
    }
}

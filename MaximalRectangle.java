public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j] = (dp[i][j] == 0) ? 1 : dp[i][j] + 1;
                } else {
                    dp[i + 1][j] = 0;
                }
            }
        }
        int maxRectangle = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < cols; j++) {
                int countCols = 0, minRows = Integer.MAX_VALUE;
                for (int k = j; k < cols && dp[i][k] != 0; k++) {
                    countCols++;
                    minRows = Math.min(minRows, dp[i][k]);
                }
                maxRectangle = Math.max(maxRectangle, minRows * countCols);
            }
        }
        return maxRectangle;
    }
}

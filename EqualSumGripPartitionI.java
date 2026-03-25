public class EqualSumGripPartitionI {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long[] prefRow = new long[n];
        long[] prefCol = new long[m];

        for (int i = 0; i < n; i++) {
            prefRow[i] = (i == 0 ? 0 : prefRow[i - 1]);
            for (int j = 0; j < m; j++) {
                prefRow[i] += grid[i][j];
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (prefRow[n - 1] - prefRow[i] == prefRow[i]) return true;
        }

        for (int i = 0; i < m; i++) {
            prefCol[i] = (i == 0 ? 0 : prefCol[i - 1]);
            for (int j = 0; j < n; j++) {
                prefCol[i] += grid[j][i];
            }
        }
        for (int i = 0; i < m - 1; i++) {
            if (prefCol[m - 1] - prefCol[i] == prefCol[i]) return true;
        }

        return false;
    }
}

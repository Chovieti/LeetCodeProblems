public class ConstructProductMatrix {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] suf = new int[n][m];
        int[][] pref = new int[n][m];
        int[][] res = new int[n][m];
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] % 12345 == 0) {
                    zeroCount++;
                    if (zeroCount >= 2) return res;
                } else {
                    suf[i][j] = (int) (((i == 0 && j == 0) ? 1 : ((j == 0) ? suf[i - 1][m - 1] : suf[i][j - 1]))
                            * (long) grid[i][j] % 12345);
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                pref[i][j] = (int) (((i == n - 1 && j == m - 1) ? 1 : ((j == m - 1) ? pref[i + 1][0] : pref[i][j + 1]))
                        * (long) grid[i][j] % 12345);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (zeroCount == 1 && grid[i][j] % 12345 != 0) continue;
                res[i][j] = (i == 0 && j == 0 ? 1 : ((j == 0) ? suf[i - 1][m - 1] : suf[i][j - 1])) *
                        ((i == n - 1 && j == m - 1) ? 1 : ((j == m - 1) ? pref[i + 1][0] : pref[i][j + 1])) % 12345;
            }
        }
        return res;
    }
}

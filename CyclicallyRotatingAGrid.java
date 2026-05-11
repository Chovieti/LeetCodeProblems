public class CyclicallyRotatingAGrid {
    public int[][] rotateGrid(int[][] grid, int k) {
        int row = grid.length, cols = grid[0].length;
//        int cycle = (row * 2) + (cols - 2) * 2;
        int l = 0, r = cols - 1, t = 0, d = row - 1;
        while (l < r && t < d) {
            int cycle = k % (((r - l) + (d - t)) * 2);
            for (int z = 0; z < cycle; z++) {
                int tmp = grid[t][l];
                // Слева направо
                for (int i = l; i < r; i++) {
                    grid[t][i] = grid[t][i + 1];
                }
                // Сверху вниз
                for (int i = t; i < d; i++) {
                    grid[i][r] = grid[i + 1][r];
                }
                // Справо налево
                for (int i = r; i > l; i--) {
                    grid[d][i] = grid[d][i - 1];
                }
                // Снизу вверх
                for (int i = d; i > t + 1; i--) {
                    grid[i][l] = grid[i - 1][l];
                }
                grid[t + 1][l] = tmp;
            }
            l++;
            r--;
            t++;
            d--;
        }
        return grid;
    }
}

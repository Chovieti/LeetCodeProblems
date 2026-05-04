public class ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // Сначала делаем сумму максимальной
        // Сначала сделать реверс всех строк которые начинаются с нуля, так как 1000 > 0111 == 8 > 7
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++) grid[i][j] ^= 1;
            }
        }
        // Затем для каждого столбца считаем количество нулей
        // Если нулей больше, значит от реверса будет выгода и проводим его
        for (int j = 1; j < n; j++) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 0) count++;
            }
            if (count * 2 > m) {
                for (int i = 0; i < m; i++) grid[i][j] ^= 1;
            }
        }
        // Затем подсчет результата
        int result = 0;
        for (int i = 0; i < m; i++) {
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                tmp |= grid[i][j] << (n - 1 - j);
            }
            result += tmp;
        }
        return result;
    }
}

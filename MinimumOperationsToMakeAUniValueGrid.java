import java.util.Arrays;

public class MinimumOperationsToMakeAUniValueGrid {
    public int minOperations(int[][] grid, int x) {
        int size = grid.length * grid[0].length;
        if (size == 1) return 0;
        int[] array = new int[size];
        for (int i = 0, div = grid[0][0] % x; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] % x != div) return -1;
                array[i * grid[0].length + j] = grid[i][j];
            }
        }
        Arrays.sort(array);
        int mediana = array[(size / 2)];
        int result = 0;
        for (int i = 0; i < size; i++) {
            result += Math.abs((mediana  - array[i]) / x);
        }
        return result;
    }
}

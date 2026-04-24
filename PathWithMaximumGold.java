import java.util.ArrayList;
import java.util.List;

public class PathWithMaximumGold {
    public int getMaximumGold(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int res = 0, gold = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                gold += grid[i][j];
                visited[i][j] = true;
                res = Math.max(res, backtracking(grid, visited, gold, i, j));
                visited[i][j] = false;
                gold -= grid[i][j];
            }
        }
        return res;
    }

    private int backtracking(int[][] grid, boolean[][] visited, int currentGold, int i, int j) {
        List<int[]> moves = getPossibleMoves(grid, visited, i, j);
        int res = currentGold;
        for (int[] move : moves) {
            currentGold += grid[move[0]][move[1]];
            visited[move[0]][move[1]] = true;
            res = Math.max(res, backtracking(grid, visited, currentGold, move[0], move[1]));
            visited[move[0]][move[1]] = false;
            currentGold -= grid[move[0]][move[1]];
        }
        return res;
    }

    private List<int[]> getPossibleMoves(int[][] grid, boolean[][] visited, int i, int j) {
        List<int[]> res = new ArrayList<>();
        if (i > 0 && !visited[i - 1][j] && grid[i - 1][j] != 0) res.add(new int[]{i - 1, j});
        if (j + 1 < grid[0].length && !visited[i][j + 1] && grid[i][j + 1] != 0) res.add(new int[]{i, j + 1});
        if (i + 1 < grid.length && !visited[i + 1][j] && grid[i + 1][j] != 0) res.add(new int[]{i + 1, j});
        if (j > 0 && !visited[i][j - 1] && grid[i][j - 1] != 0) res.add(new int[]{i, j - 1});
        return res;
    }
}

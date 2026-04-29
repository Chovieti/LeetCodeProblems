import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    record Pair(int i, int j) {}
    public int orangesRotting(int[][] grid) {
        int maxTime = 0, fresh = 0, m = grid.length, n = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) fresh++;
                else if (grid[i][j] == 2) queue.add(new Pair(i, j));
            }
        }
        maxTime = bfs(queue, grid, fresh);
        return maxTime;
    }

    private int bfs(Queue<Pair> queue, int[][] grid, int fresh) {
        int time = 0;
        int m = grid.length, n = grid[0].length;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair cur = queue.poll();
                if (checkAndChange(queue, grid, cur.i + 1, cur.j)) fresh--;
                if (checkAndChange(queue, grid, cur.i, cur.j + 1)) fresh--;
                if (checkAndChange(queue, grid, cur.i - 1, cur.j)) fresh--;
                if (checkAndChange(queue, grid, cur.i, cur.j - 1)) fresh--;
            }
            if (!queue.isEmpty()) time++; // Если есть куда дальше распространятся то время увеличивается
        }
        if (fresh > 0) return -1;
        return time;
    }

    private boolean checkAndChange(Queue<Pair> queue, int[][] grid, int i, int j) {
        if (i < grid.length && i >= 0 && j < grid[0].length && j >= 0 && grid[i][j] == 1) {
            queue.add(new Pair(i, j));
            grid[i][j] = 2;
            return true;
        }
        return false;
    }
}

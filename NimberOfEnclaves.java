import java.util.ArrayDeque;
import java.util.Deque;

public class NimberOfEnclaves {
    record Coor(int i, int j) {}
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Deque<Coor> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) pushAndVisit(stack, visited, new Coor(i, 0));
            if (i != 0 && i != n - 1 && grid[i][m - 1] == 1) pushAndVisit(stack, visited, new Coor(i, m - 1));
        }
        for (int i = 0; i < m; i++) {
            if (i != 0 && grid[0][i] == 1) pushAndVisit(stack, visited, new Coor(0, i));
            if (i != 0 && grid[n - 1][i] == 1) pushAndVisit(stack, visited, new Coor(n - 1, i));
        }

        while (!stack.isEmpty()) {
            Coor cur = stack.poll();
            int i = cur.i, j = cur.j;
            if (i > 0 && !visited[i - 1][j] && grid[i - 1][j] == 1) pushAndVisit(stack, visited, new Coor(i - 1, j));
            if (j > 0 && !visited[i][j - 1] && grid[i][j - 1] == 1) pushAndVisit(stack, visited, new Coor(i, j - 1));
            if (i + 1 != n && !visited[i + 1][j] && grid[i + 1][j] == 1) pushAndVisit(stack, visited, new Coor(i + 1, j));
            if (j + 1 != m && !visited[i][j + 1] && grid[i][j + 1] == 1) pushAndVisit(stack, visited, new Coor(i, j + 1));
        }

        int result = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) result++;
            }
        }

        return result;
    }

    private void pushAndVisit(Deque<Coor> stack, boolean[][] visit, Coor c) {
        stack.push(c);
        visit[c.i][c.j] = true;
    }
}

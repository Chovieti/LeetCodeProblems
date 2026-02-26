import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    record Pair(int y, int x) {}
    public int numIslands(char[][] grid) {
        int countIslands = 0, m = grid.length, n = grid[0].length;
        Queue<Pair> bfs = new LinkedList<>();
        boolean[][] visited = new boolean[m][];
        for (int i = 0; i < m; i++) visited[i] = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    countIslands++;
                    bfs.add(new Pair(i, j));
                    visited[i][j] = true;
                    bfs(bfs, visited, grid, m, n);
                }
            }
        }

        return countIslands;
    }

    private void bfs(Queue<Pair> bfs, boolean[][] visited, char[][] grid, int m, int n) {
        while (!bfs.isEmpty()) {
            Pair cur = bfs.poll();
            int y = cur.y;
            int x = cur.x;
            visited[y][x] = true;
            if (y + 1 < m && !visited[y + 1][x] && grid[y + 1][x] == '1') {
                bfs.add(new Pair(y + 1, x));
                visited[y + 1][x] = true;
            }
            if (y - 1 >= 0 && !visited[y - 1][x] && grid[y - 1][x] == '1') {
                bfs.add(new Pair(y - 1, x));
                visited[y - 1][x] = true;
            }
            if (x + 1 < n && !visited[y][x + 1] && grid[y][x + 1] == '1') {
                bfs.add(new Pair(y, x + 1));
                visited[y][x + 1] = true;
            }
            if (x - 1 >= 0 && !visited[y][x - 1] && grid[y][x - 1] == '1') {
                bfs.add(new Pair(y, x - 1));
                visited[y][x - 1] = true;
            }
        }
    }
}

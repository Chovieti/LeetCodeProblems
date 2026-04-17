import java.util.ArrayDeque;
import java.util.Deque;

public class WordSearch {
    int n, m;
    record Coor(int i, int j) {}
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        int curInd = 0;
        Deque<Coor> stack = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        fillStack(board, word.charAt(curInd), stack);
        while (!stack.isEmpty()) {
            Coor cur = stack.pop();
            visited[cur.i][cur.j] = true;
            if (curInd + 1 == word.length()) return true;
            Deque<Coor> newStack = checkNeighboors(board, visited, word.charAt(curInd + 1), cur);
            if (backtracking(board, word, cur, visited, curInd)) return true;
        }
        return false;
    }

    private boolean backtracking(char[][] board, String word, Coor cur, boolean[][] visited, int curInd) {
        visited[cur.i][cur.j] = true;
        if (curInd + 1 == word.length()) return true;
        Deque<Coor> newStack = checkNeighboors(board, visited, word.charAt(curInd + 1), cur);
        while (!newStack.isEmpty()) {
            Coor next = newStack.pop();
            if (backtracking(board, word, next, visited, curInd + 1)) return true;
        }
        visited[cur.i][cur.j] = false;
        return false;
    }

    private void fillStack(char[][] board, char first, Deque<Coor> stack) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == first) {
                    stack.push(new Coor(i, j));
                }
            }
        }
    }

    private Deque<Coor> checkNeighboors(char[][] board, boolean[][] visited, char next, Coor cur) {
        Deque<Coor> stack = new ArrayDeque<>();
        if (cur.i - 1 >= 0 && !visited[cur.i - 1][cur.j] && board[cur.i - 1][cur.j] == next) stack.push(new Coor(cur.i - 1, cur.j));
        if (cur.j + 1 < m  && !visited[cur.i][cur.j + 1]&& board[cur.i][cur.j + 1] == next) stack.push(new Coor(cur.i, cur.j + 1));
        if (cur.i + 1 < n  && !visited[cur.i + 1][cur.j]&& board[cur.i + 1][cur.j] == next) stack.push(new Coor(cur.i + 1, cur.j));
        if (cur.j - 1 >= 0 && !visited[cur.i][cur.j - 1] && board[cur.i][cur.j - 1] == next) stack.push(new Coor(cur.i, cur.j - 1));
        return stack;
    }
}

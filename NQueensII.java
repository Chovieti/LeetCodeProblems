import java.util.Arrays;

public class NQueensII {
    public int totalNQueens(int n) {
        int result = 0;
        int[] cols = new int[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        Arrays.fill(cols, -1);
        for (int i = 0; i < n; i++) {
            cols[0] = i;
            diag1[n - 1 + i] = true;
            diag2[i] = true;
            result = backtrack(result, cols, diag1, diag2, 1);
            diag1[n - 1 + i] = false;
            diag2[i] = false;
            cols[0] = -1;
        }
        return result;
    }

    private int backtrack(int result, int[] cols, boolean[] diag1, boolean[] diag2, int numberQueens) {
        if (numberQueens == cols.length) {
            return result + 1;
        }
        int n = cols.length;
        int res = result;
        for (int i = 0; i < n; i++) {
            if (checkAccess(cols, diag1, diag2, numberQueens, i)) {
                cols[numberQueens] = i;
                diag1[n - 1 - numberQueens + i] = true;
                diag2[numberQueens + i] = true;
                res = backtrack(res, cols, diag1, diag2, numberQueens + 1);
                diag2[numberQueens + i] = false;
                diag1[n - 1 - numberQueens + i] = false;
                cols[numberQueens] = -1;
            }
        }
        return res;
    }

    private boolean checkAccess(int[] cols, boolean[] diag1, boolean[] diag2, int iC, int jC) {
        int n = cols.length - 1;
        for (int i = 0; i <= n; i++) {
            if (cols[i] == -1) break;
            if (cols[i] == jC) return false;
        }
        return !diag1[n - iC + jC] && !diag2[iC + jC];
    }
}

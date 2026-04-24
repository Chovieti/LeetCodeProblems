import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] cols = new int[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        Arrays.fill(cols, -1);
        for (int i = 0; i < n; i++) {
            cols[0] = i;
            diag1[n - 1 + i] = true;
            diag2[i] = true;
            backtrack(result, cols, diag1, diag2, 1);
            diag1[n - 1 + i] = false;
            diag2[i] = false;
            cols[0] = -1;
        }
        return result;
    }

    private void backtrack(List<List<String>> result, int[] cols, boolean[] diag1, boolean[] diag2, int numberQueens) {
        if (numberQueens == cols.length) {
            result.add(createAnswer(cols));
            return;
        }
        int n = cols.length;
        for (int i = 0; i < n; i++) {
            if (checkAccess(cols, diag1, diag2, numberQueens, i)) {
                cols[numberQueens] = i;
                diag1[n - 1 - numberQueens + i] = true;
                diag2[numberQueens + i] = true;
                backtrack(result, cols, diag1, diag2, numberQueens + 1);
                diag2[numberQueens + i] = false;
                diag1[n - 1 - numberQueens + i] = false;
                cols[numberQueens] = -1;
            }
        }
    }

    private boolean checkAccess(int[] cols, boolean[] diag1, boolean[] diag2, int iC, int jC) {
        int n = cols.length - 1;
        for (int i = 0; i <= n; i++) {
            if (cols[i] == -1) break;
            if (cols[i] == jC) return false;
        }
        return !diag1[n - iC + jC] && !diag2[iC + jC];
    }

    private List<String> createAnswer(int[] cols) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < cols.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < cols.length; j++) {
                builder.append(cols[i] == j ? 'Q' : '.');
            }
            answer.add(builder.toString());
        }
        return answer;
    }
}

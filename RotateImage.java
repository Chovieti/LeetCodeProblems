public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length, l = 0, r = n - 1;
        while (l < r) {
            for (int i = 0; l + i < r; i++) {
                int tmp = matrix[l][l + i];
                matrix[l][l + i] = matrix[r - i][l];
                matrix[r - i][l] = matrix[r][r - i];
                matrix[r][r - i] = matrix[l + i][r];
                matrix[l + i][r] = tmp;
            }
            l++;
            r--;
        }
    }
}

// 3 X 3

// 0.0  0.1  0.2
// 1.0  1.1  1.2
// 2.0  2.1  2.2

// 0.0 -> 0.2 -> 2.2 -> 2.0 -> 0.0
// 0.1 -> 1.2 -> 2.1 -> 1.0 -> 0.1

// 4 X 4

// 0.0  0.1  0.2  0.3
// 1.0  1.1  1.2  1.3
// 2.0  2.1  2.2  2.3
// 3.0  3.1  3.2  3.3

// l.(l+i)      (l+i).r     r.(r-i)     (r-i).l
// Внешний цикл
// 0.0 ->       0.3 ->      3.3 ->      3.0 ->      0.0
// 0.1 ->       1.3 ->      3.2 ->      2.0 ->      0.1
// 0.2 ->       2.3 ->      3.1 ->      1.0 ->      0.2

// Внутренний
// 1.1 ->       1.2 ->      2.2 ->      2.1 ->      1.1
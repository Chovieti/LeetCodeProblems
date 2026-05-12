import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    // Один проход с битовыми масками
    public boolean isValidSudoku(char[][] board) {
        int[] masks = new int[27]; // 9 - строк + 9 - столбцов + 9 - квадратов
        for (int index = 0; index < 81; index++) {
            char cur = board[index / 9][index % 9];
            if (cur == '.') continue;
            int number = cur - 48;
            // Маска строки
            if (((masks[index / 9] >> number) & 1) == 1) return false;
            masks[index / 9] |= 1 << number;
            // Маска столбца
            if (((masks[(index % 9) + 9] >> number) & 1) == 1) return false;
            masks[(index % 9) + 9] |= 1 << number;
            // Маска квадрата
            int box = (index / 27) * 3 + (index % 9) / 3;
            if (((masks[box + 18] >> number) & 1) == 1) return false;
            masks[box + 18] |= 1 << number;
        }
        return true;
    }
    // Проверка по очереди сначала строк, затем столбцов, затем квадратов
//    public boolean isValidSudoku(char[][] board) {
//        Set<Integer> heap = new HashSet<>();
//        // Check rows
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                if (board[i][j] == '.') continue;
//                int number = board[i][j] - 48;
//                if (heap.contains(number)) return false;
//                heap.add(number);
//            }
//            heap.clear();
//        }
//        // Check cols
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                if (board[j][i] == '.') continue;
//                int number = board[i][j] - 48;
//                if (heap.contains(number)) return false;
//                heap.add(number);
//            }
//            heap.clear();
//        }
//        // Check square
//        for (int k = 0; k < 9; k++) {
//            for (int i = 0; i < 3; i++) {
//                for (int j = 0; j < 3; j++) {
//                    char cur = board[i + ((k / 3) * 3)][j + ((k % 3) * 3)];
//                    if (cur == '.') continue;
//                    int number = cur - 48;
//                    if (heap.contains(number)) return false;
//                    heap.add(number);
//                }
//            }
//            heap.clear();
//        }
//        return true;
//    }
}

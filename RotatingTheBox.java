import java.util.ArrayList;
import java.util.List;

public class RotatingTheBox {
//    Вариант с одним проходом по матрицу и заполнением через два указателя
    public char[][] rotateTheBox(char[][] boxGrid) {
        int row = boxGrid.length, col = boxGrid[0].length;
        char[][] result = new char[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = col - 1, p = col - 1; j >= 0; j--) {
                char cur = boxGrid[i][j];
                switch (cur) {
                    case '*' -> {
                        while (p > j) {
                            result[p--][row - i - 1] = '.';
                        }
                        result[p--][row - i - 1] = '*';
                    }
                    case '#' -> result[p--][row - i - 1] = '#';
                }
                while (j == 0 && p >= j) result[p--][row - i - 1] = '.';
            }
        }
        return result;
    }
//    Первоначальный самописный вариант с построением сегментов между неподвижными припятствиями
//    по которым я потом заполняю перевернутую коробку
//    public char[][] rotateTheBox(char[][] boxGrid) {
//        int m = boxGrid.length, n = boxGrid[0].length;
//        List<List<int[]>> box = new ArrayList<>(m);
//        // Заполнение сегментов
//        for (int i = 0; i < m; i++) {
//            List<int[]> row = new ArrayList<>();
//            boolean newSegment = false;
//            int[] segment = new int[3];
//            for (int j = 0; j < n; j++) {
//                if (newSegment) {
//                    segment = new int[3]; // 0 - свободное пространство, 1 - камни, 2 - неподвижиные стенки
//                    newSegment = false;
//                }
//                switch (boxGrid[i][j]) {
//                    case '.' -> segment[0]++;
//                    case '#' -> segment[1]++;
//                    case '*' -> {
//                        while (j < n && boxGrid[i][j] == '*') {
//                            segment[2]++;
//                            j++;
//                        }
//                        j--;
//                        row.add(segment);
//                        newSegment = true;
//                    }
//                }
//            }
//            if (!newSegment) row.add(segment);
//            box.add(row);
//        }
//        // Заполнение коробки
//        char[][] result = new char[n][m];
//        for (int i = 0; i < m; i++) {
//            List<int[]> col = box.get(i);
//            int j = 0;
//            for (int k = 0; k < col.size(); k++) {
//                int[] segment = col.get(k);
//                while (segment[0]-- > 0) result[j++][m - i - 1] = '.';
//                while (segment[1]-- > 0) result[j++][m - i - 1] = '#';
//                while (segment[2]-- > 0) result[j++][m - i - 1] = '*';
//            }
//        }
//        return result;
//    }
}

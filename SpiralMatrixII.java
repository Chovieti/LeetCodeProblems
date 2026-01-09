public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] array = new int[n][n];
        int iStart = 0, iEnd = n - 1, jStart = 0, jEnd = n - 1, count = 1, end = n * n;
        while (count <= end) {
            if (count == end) {
                array[iStart][iStart] = count;
                break;
            }
            for (int i = jStart; i < jEnd; i++) {
                array[iStart][i] = count;
                count++;
            }
            for (int i = iStart; i < iEnd; i++) {
                array[i][jEnd] = count;
                count++;
            }
            for (int i = jEnd; i > jStart; i--) {
                array[iEnd][i] = count;
                count++;
            }
            for (int i = iEnd; i > iStart; i--) {
                array[i][iStart] = count;
                count++;
            }
            iStart++;
            jStart++;
            iEnd--;
            jEnd--;
        }
        return array;
    }
}

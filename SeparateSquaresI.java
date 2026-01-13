public class SeparateSquaresI {
    public double separateSquares(int[][] squares) {
        double min = squares[0][1], max = min + squares[0][2];
        int l = squares.length;
        for (int i = 1; i < l; i++) {
            min = Math.min(min, squares[i][1]);
            max = Math.max(max, squares[i][1] + squares[i][2]);
        }

        double mid = (max + min) / 2, result = Double.MAX_VALUE;
        while (Math.abs(max - min) > 1e-6) {
            int res = calcSquares(squares, mid);
            if (res == 0) {
                System.out.println(mid);
                result = Math.min(result, mid);
                max = mid;
                mid = (max + min) / 2;
            } else if (res == 1) {
                min = mid;
                mid = (max + min) / 2;
            } else if (res == -1) {
                max = mid;
                mid = (max + min) / 2;
            }
        }
        if (result == Double.MAX_VALUE) result = mid;

        return result;
    }

    private int calcSquares(int[][] squares, double mid) {
        double squareUpper = 0.0, squareBottom = 0.0;
        for (int i = 0; i < squares.length; i++) {
            if (squares[i][1] >= mid) {
                // Если квадрат выше линии
                squareUpper += 2.0 * Math.pow(squares[i][2], 2.0);
            } else if (squares[i][1] < mid && (squares[i][1] + squares[i][2]) <= mid) {
                // Если квадрат ниже линии
                squareBottom += 2.0 * Math.pow(squares[i][2], 2.0);
            } else {
                // Если квадрат на линии
                double bottom = squares[i][1], top = bottom + squares[i][2];
                squareUpper += 2.0 * (top - mid) * squares[i][2];
                squareBottom += 2.0 * (mid - bottom) * squares[i][2];
            }
        }
        if (Math.abs(squareUpper - squareBottom) <= 1e-6) return 0;
        if (squareUpper - squareBottom > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}

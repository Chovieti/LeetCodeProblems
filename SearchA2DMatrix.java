public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int right = matrix.length * matrix[0].length;
        int left = 0;
        int mid = right / 2;
        while (left <= right) {
            int current = matrix[mid / matrix.length][mid % matrix.length];
            if (current == target) return true;
            if (current < target) {
                left = mid + 1;
                mid = (right + left) / 2;
            } else if (current > target) {
                right = mid - 1;
                mid = (right + left) / 2;
            }
        }
        return false;
    }
}

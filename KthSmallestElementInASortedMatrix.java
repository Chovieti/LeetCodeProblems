import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementInASortedMatrix {
    class Pair {
        int value, row, col;
        public Pair(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
        for (int i = 0; i < matrix.length; i++) {
            minHeap.add(new Pair(matrix[i][0], i, 0));
        }
        int result = 0;
        for (int i = 0; i < k; i++) {
            Pair cur = minHeap.poll();
            if (cur.col + 1 < matrix[cur.row].length) {
                minHeap.add(new Pair(matrix[cur.row][cur.col + 1], cur.row, cur.col + 1));
            }
            result = cur.value;
        }
        return result;
    }
}

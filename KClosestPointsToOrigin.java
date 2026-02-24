import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {
    class Pair {
        int value, index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        Queue<Pair> heap = new PriorityQueue<>((a, b) -> b.value - a.value);
        for (int i = 0; i < points.length; i++) {
            int value = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            heap.add(new Pair(value, i));
            if (heap.size() > k) heap.poll();
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            int index = heap.poll().index;
            res[i][0] = points[index][0];
            res[i][1] = points[index][1];
        }
        return res;
    }
}

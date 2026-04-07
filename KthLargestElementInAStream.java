import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAStream {
    class KthLargest {
        private Queue<Integer> heap = new PriorityQueue<>();
        int k;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int i = 0; i < nums.length; i++) {
                heap.add(nums[i]);
                if (heap.size() > k) heap.poll();
            }
        }

        public int add(int val) {
            heap.add(val);
            if (heap.size() > k) heap.poll();
            return heap.peek();
        }
    }
}

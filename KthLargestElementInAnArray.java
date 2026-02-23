import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) heap.add(num);
        for (int i = 1; i < k; i++) heap.poll();
        return heap.peek();
    }
}

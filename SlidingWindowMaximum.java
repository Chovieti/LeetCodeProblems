import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMaximum {
    class Pair {
        int value, index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Pair> heap = new PriorityQueue<>((a, b) -> b.value - a.value);
        Queue<Integer> max = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            heap.add(new Pair(nums[i], i));
            while (heap.peek().index <= i - k) heap.poll();
            if (heap.size() >= k) max.add(heap.peek().value);
        }
        int[] res = new int[max.size()];
        for (int i = 0; i < res.length; i++) res[i] = max.poll();
        return res;
    }
}

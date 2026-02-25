import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    class MedianFinder {
        private final PriorityQueue<Integer> largerHeap;
        // Хранит значения второй половины массива, в голове храниться наименьшее из этой половины
        private final PriorityQueue<Integer> lesserHeap;
        // Хранит значения первой половины массива, в голове храниться наибольшее из этой половины
        public MedianFinder() {
            this.largerHeap = new PriorityQueue<>();
            this.lesserHeap = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int num) {
            if (largerHeap.size() == lesserHeap.size()) {
                // Если размер равен, то нужно добавить в largerHeap
                if (largerHeap.size() == 0 || num >= lesserHeap.peek()) {
                    largerHeap.add(num);
                } else {
                    largerHeap.add(lesserHeap.poll());
                    lesserHeap.add(num);
                }
            } else {
                // Если размер равен, значит larger уже больше и нужно добавлять в lesser
                if (num >= largerHeap.peek()) {
                    lesserHeap.add(largerHeap.poll());
                    largerHeap.add(num);
                } else {
                    lesserHeap.add(num);
                }
            }
        }

        public double findMedian() {
            if ((largerHeap.size() + lesserHeap.size()) % 2 == 1) {
                return (double) largerHeap.peek();
            } else {
                return (largerHeap.peek() + lesserHeap.peek()) / 2.0;
            }
        }
    }
}

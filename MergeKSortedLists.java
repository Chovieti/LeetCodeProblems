import java.util.PriorityQueue;
import java.util.Queue;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {}
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> heap = new PriorityQueue<>((e1, e2) -> e2.val - e1.val);
        for (int i = 0; i < lists.length; i++) {
            ListNode cur = lists[i];
            while (cur != null) {
                heap.add(cur);
                cur = cur.next;
            }
        }
        ListNode res = null, next = null;
        while (!heap.isEmpty()) {
            res = heap.poll();
            res.next = next;
            next = res;
        }
        return res;
    }
}

import java.util.ArrayList;
import java.util.List;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        List<ListNode> array = new ArrayList<>();
        ListNode cur = head;
        do {
            array.add(new ListNode(cur.val));
            cur = cur.next;
        } while (cur != null);
        int n = array.size();
        k = (k % n);
        ListNode newHead = null;
        for (int i = n - 1; i >= 0; i--) {
            cur = array.get((i - k + n) % n);
            if (newHead == null) {
                newHead = new ListNode(cur.val);
            } else {
                newHead = new ListNode(cur.val, newHead);
            }
        }
        return newHead;
    }
}

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> array = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            array.add(cur);
            cur = cur.next;
        }
        int prev = array.size() - n - 1;
        int next = array.size() - n + 1;
        if (prev == -1) {
            head = head.next;
            if (head != null) head = next >= array.size() ? null : array.get(next);
        } else {
            array.get(prev).next = next >= array.size() ? null : array.get(next);
        }
        return head;
    }
}

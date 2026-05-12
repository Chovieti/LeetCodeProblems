import java.util.ArrayList;
import java.util.List;

public class ReorderList {
    public void reorderList(ListNode head) {
        List<ListNode> array = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            array.add(cur);
            cur = cur.next;
        }
        int l = 0, r = array.size() - 1;
        ListNode first = array.get(l);
        ListNode second;
        while (l < r) {
            second = array.get(r);
            first.next = second;
            l++;
            if (l == r) {
                second.next = null;
                break;
            }
            first = array.get(l);
            second.next = first;
            r--;
            if (l == r) first.next = null;
        }
    }
}

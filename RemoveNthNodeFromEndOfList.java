import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndOfList {
    // Вариант через указатели
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tail = head.next;
        int size = 1;
        while (tail != null) {
            tail = tail.next;
            size++;
        }
        if (size == n) return head.next;
        ListNode prev = head;
        tail = head.next;
        for (int i = 2; i <= size - n; i++) {
            prev = tail;
            tail = tail.next;
        }
        prev.next = tail.next;
        return head;
    }

    // Вариант через массив и вычисление какие элементы нужно связать
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        List<ListNode> array = new ArrayList<>();
//        ListNode cur = head;
//        while (cur != null) {
//            array.add(cur);
//            cur = cur.next;
//        }
//        int prev = array.size() - n - 1;
//        int next = array.size() - n + 1;
//        if (prev == -1) {
//            head = head.next;
//            if (head != null) head = next >= array.size() ? null : array.get(next);
//        } else {
//            array.get(prev).next = next >= array.size() ? null : array.get(next);
//        }
//        return head;
//    }
}

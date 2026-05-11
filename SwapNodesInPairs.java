public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode prev = null;
        ListNode first = (head != null) ? head.next : null;
        ListNode second = head;
        ListNode next = (first != null) ? first.next : null;
        if (first == null || second == null) return head;
        first.next = second;
        second.next = next;
        prev = second;
        head = first;
        do {
            second = next;
            first = (second != null) ? second.next : null;
            next = (first != null) ? first.next : null;
            if (first != null) {
                prev.next = first;
                first.next = second;
                second.next = next;
                prev = second;
            }
        } while (next != null);
        return head;
    }
}

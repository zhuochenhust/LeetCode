package linkedlist;

public class SwapNodesInParis_024 {
	public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cursor = dummy;
        while (cursor.next != null && cursor.next.next != null) {
            ListNode n1 = cursor.next, n2 = cursor.next.next;
            n1.next = n2.next;
            n2.next = n1;
            cursor.next = n2;
            cursor = n1;
        }
        return dummy.next;
    }
}

package linkedlist;

public class RemoveLinkedListElements_203 {
	public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode cursor = dummy;
        cursor.next = head;
        while (head != null) {
            if (head.val == val) {
                cursor.next = cursor.next.next;
                head = head.next;
            } else {
                cursor = cursor.next;
                head = head.next;
            }
        }
        return dummy.next;
    }
}

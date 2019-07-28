package linkedlist;

public class ReverseLinkedList_206 {
	public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode cursor = head; // cursor代表当前ListNode
        while (cursor != null) {
            ListNode nextTemp = cursor.next;
            cursor.next = prev;
            prev = cursor;
            cursor = nextTemp;
        }
        return prev;
    }
}

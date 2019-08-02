package linkedlist;

public class RemoveNthNodeFromEndOfList_019 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        int len = getLength(head);
        if (n > len) return head;
        ListNode dummy = new ListNode(0);
        ListNode cursor = dummy;
        cursor.next = head;
        for (int i = 0; i < len - n; i ++) {
            cursor = cursor.next;
        }
        cursor.next = cursor.next.next;
        return dummy.next;
    }
    
    public int getLength(ListNode head) {
        if (head == null) return 0;
        ListNode cursor = head;
        int len = 0;
        while (cursor != null) {
            len ++;
            cursor = cursor.next;
        }
        return len;
    }
}

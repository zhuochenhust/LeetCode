package linkedlist;

public class RotateList_061 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int len = getLength(head);
        k = k % len;
        for (int i = 0; i < k; i ++) {
            head = rotateRight(head);
        }
        return head;
    }
    
    public ListNode rotateRight(ListNode head) {
        ListNode secondLast = head;
        ListNode last = head.next;
        while (last.next != null) {
            last = last.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
        last.next = head;
        return last;
    }
    
    public int getLength(ListNode head) {
        int len = 0;
        ListNode cursor = head;
        while (cursor != null) {
            len ++;
            cursor = cursor.next;
        }
        return len;
    }
} 

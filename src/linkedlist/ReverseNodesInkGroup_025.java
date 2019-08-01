package linkedlist;

public class ReverseNodesInkGroup_025 {
	public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode cursor = dummy;
        cursor.next = head;
        while (true) {
            if (cursor == null) break;
            cursor = reverseK(cursor, k);
        }
        return dummy.next;
    }
    
    public ListNode reverseK(ListNode cursor, int k) {
        ListNode nk = cursor;
        for (int i = 0; i < k; i ++) {
            if (nk == null) return null;
            nk = nk.next;
        }
        if (nk == null) return null;
        ListNode nkplus = nk.next;
        ListNode prev = null;
        ListNode head = cursor.next;
        ListNode n1 = head;
        while (head != nkplus) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        n1.next = nkplus;
        cursor.next = nk;
        cursor = n1;
        return n1;
    }
}	

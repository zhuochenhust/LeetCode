package linkedlist;

import org.junit.Test;

public class ReorderList_143 {
	public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        ListNode mid = findMiddle(head);
        ListNode tail = reverse(mid.next);
        mid.next = null;
        
        merge(head, tail);
    }
    
    public ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }
    
    public void merge (ListNode head1, ListNode head2) {
        ListNode cursor = new ListNode(0);
        int index = 0;
        while (head1 != null && head2 != null) {
            if (index % 2 == 0) {
                cursor.next = head1;
                head1 = head1.next;
            } else {
                cursor.next = head2;
                head2 = head2.next;
            }
            cursor = cursor.next;
            index ++;
        }
        if (head1 != null) {
            cursor.next = head1;
        }
        if (head2 != null) {
            cursor.next = head2;
        }
    }
    
    @Test
    public void testSolution() {
    	ListNode head = new ListNode(1);
    	ListNode n2 = new ListNode(2);
    	ListNode n3 = new ListNode(3);
    	ListNode n4 = new ListNode(4);
    	head.next = n2;
    	n2.next = n3;
    	n3.next = n4;
    	n4.next = null;
    	reorderList(head);
    }
}

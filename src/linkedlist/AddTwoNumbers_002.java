package linkedlist;

public class AddTwoNumbers_002 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        ListNode result = null, tmp = null;
        if (getLength(l1) >= getLength(l2)) {
            result = l1;
            tmp = l2;
        } else {
            result = l2;
            tmp = l1;
        }
        ListNode head = result;
        int sum = 0;
        boolean inc = false;
        while (result.next != null && tmp.next != null) {
            sum = result.val + tmp.val + (inc ? 1 : 0);
            result.val = sum % 10;
            inc = (sum > 9);
            result = result.next;
            tmp = tmp.next;
        }
        sum = result.val + tmp.val + (inc ? 1 : 0);
        inc  = (sum > 9);
        result.val = sum % 10;
        while (result.next != null) {
            result = result.next;
            sum = result.val + (inc ? 1 : 0);
            result.val = sum % 10;
            inc = (sum > 9);
        }
        if (inc) {
            result.next = new ListNode(1);
        }
        return head;
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

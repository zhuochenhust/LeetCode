package linkedlist;

public class MergeKSortedLists_023 {
	public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return helper(lists, 0, lists.length - 1);
    }
    
    public ListNode helper(ListNode[] lists, int low, int high) {
        if (low == high) return lists[low];
        int mid = low + (high - low) / 2;
        ListNode left = helper(lists, low, mid);
        ListNode right = helper(lists, mid + 1, high);
        return merge2Lists(left, right);
    }
    
    public ListNode merge2Lists(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        
        ListNode dummy = new ListNode(0);
        ListNode cursor = dummy;
        while(head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                cursor.next = head1;
                cursor = cursor.next;
                head1 = head1.next;
            } else {
                cursor.next = head2;
                cursor = cursor.next;
                head2 = head2.next;
            }
        }
        if (head1 != null) {
            cursor.next = head1;
        }
        if (head2 != null) {
            cursor.next = head2;
        }
        return dummy.next;
    }
}

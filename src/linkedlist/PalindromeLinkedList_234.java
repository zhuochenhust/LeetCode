package linkedlist;

public class PalindromeLinkedList_234 {
	public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode mid = findMiddle(head);
        mid.next = reverse(mid.next);
        ListNode h1 = head, h2 = mid.next;
        while (h1 != null && h2 != null && h1.val == h2.val) {
            h1 = h1.next;
            h2 = h2.next;
        }
        return h2 == null; // h2可以走到尽头(null)意味着是回文的
    }
    
    public ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        while(head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }
}

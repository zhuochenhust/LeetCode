package linkedlist;

public class LinkedListCycle_141 {
	// 看有没有环，设定两个指针，fast和slow，slow一次一步，fast一次两步，
    // 如果fast能绕一圈追上slow，则返回true
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head, fast = head.next;
        while (slow != fast) { // 只要fast没追上slow，就继续跑
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}

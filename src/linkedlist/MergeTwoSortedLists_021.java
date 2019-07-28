package linkedlist;

public class MergeTwoSortedLists_021 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        // 这里记住初始化一个ListNode如果未来直接给他赋值一个ListNode，可以初始化为null
        // 如果是要它的next指向一个另一个ListNode，就不能初始值为null了，要new ListNode(随便什么值)
        ListNode head = new ListNode(0), cursor = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cursor.next = l1;
                l1 = l1.next;
                cursor = cursor.next;
            } else {
                cursor.next = l2;
                l2 = l2.next;
                cursor = cursor.next;
            }
        }
        if (l1 != null) {
            cursor.next = l1;
        }
        if (l2 != null) {
            cursor.next = l2;
        }
        return head.next;
    }
}

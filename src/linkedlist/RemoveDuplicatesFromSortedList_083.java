package linkedlist;

public class RemoveDuplicatesFromSortedList_083 {
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head != null && head.next != null) { // 别疏忽循环条件
            while (head.next != null && head.val == head.next.val) { // 别疏忽循环条件
                head.next = head.next.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}

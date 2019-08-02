package linkedlist;

public class RemoveDuplicatesFromSortedList_II_082 {
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode cursor = dummy;
        cursor.next = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                int value = head.val;
                // 别疏忽循环前提条件head!=null, head会一直往后走，如果null的话就没有val了会报空指针
                while (head != null && head.val == value) { 
                    head = head.next;
                }
                cursor.next = head;
            } else {
                cursor = cursor.next;
                head = head.next;
            }       
        }
        return dummy.next;
    }
}

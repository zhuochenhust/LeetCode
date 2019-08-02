package linkedlist;

public class PartitionList_086 {
	public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode leftDummy = new ListNode(0), rightDummy = new ListNode(0);
        ListNode leftCursor = leftDummy, rightCursor = rightDummy;
        
        while (head != null) {
            if (head.val < x) {
                leftCursor.next = head;
                leftCursor = leftCursor.next;
            } else {
                rightCursor.next = head;
                rightCursor = rightCursor.next;
            }
            head = head.next;
        }
        rightCursor.next = null;
        leftCursor.next = rightDummy.next;
        return leftDummy.next;
    }
}

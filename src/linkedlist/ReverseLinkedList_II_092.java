package linkedlist;

public class ReverseLinkedList_II_092 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        ListNode cursor = dummy;
        cursor.next = head;
        for (int i = 1; i < m; i ++) {
            cursor = cursor.next;
        }
        ListNode prevM = cursor;
        ListNode nodeM = cursor.next;
        ListNode nodeN = nodeM;
        ListNode postN = nodeN.next;
        for (int i = m; i < n; i ++) {
            ListNode tmp = postN.next;
            postN.next = nodeN;
            nodeN = postN;
            postN = tmp;
        }
        nodeM.next = postN;
        prevM.next = nodeN;
        return dummy.next;
    }
}

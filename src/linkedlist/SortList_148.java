package linkedlist;

public class SortList_148 {
	// 方法1: 利用merge sort
	public ListNode sortList_merge(ListNode head) { // 分治算法，递归
        if (head == null || head.next == null) return head;
        ListNode mid = findMiddle(head);
        ListNode right = sortList_merge(mid.next);
        mid.next = null;
        ListNode left = sortList_merge(head);
        return merge(left, right);
    }
    
    // find middle list node
    public ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    // merge two sorted lists
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(1);
        ListNode cursor = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                cursor.next = head1;
                head1 = head1.next;
            } else {
                cursor.next = head2;
                head2 = head2.next;
            }
            cursor = cursor.next;
        }
        if (head1 != null) {
            cursor.next = head1;
        }
        if (head2 != null) {
            cursor.next = head2;
        }
        return dummy.next;
    }
    
    // 方法2: 利用quick sort
    public ListNode sortList_quick(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
       
        ListNode mid = findMedian(head); // O(n)
       
        ListNode leftDummy = new ListNode(0), leftTail = leftDummy;
        ListNode rightDummy = new ListNode(0), rightTail = rightDummy;
        ListNode middleDummy = new ListNode(0), middleTail = middleDummy;
        while (head != null) {
            if (head.val < mid.val) {
                leftTail.next = head;
                leftTail = head;
            } else if (head.val > mid.val) { 
            	// mid是一定要有的，不能直接head.val<= mid.val就left
            	// 那样在leftDummy-->2-->1-->null的情况下sortList_quick(leftDummy.next)
            	// 永远都排不出序来，会一直是leftDummy-->2-->1-->null
                rightTail.next = head;
                rightTail = head;
            } else {
                middleTail.next = head;
                middleTail = head;
            }
            head = head.next;
        }
       
        leftTail.next = null;
        middleTail.next = null;
        rightTail.next = null;
       
        ListNode left = sortList_quick(leftDummy.next);
        ListNode right = sortList_quick(rightDummy.next);
       
        return concat(left, middleDummy.next, right);
    }
   
    private ListNode findMedian(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
   
    private ListNode concat(ListNode left, ListNode middle, ListNode right) {
        ListNode dummy = new ListNode(0), tail = dummy;
       
        tail.next = left; tail = getTail(tail);
        tail.next = middle; tail = getTail(tail);
        tail.next = right; tail = getTail(tail);
        return dummy.next;
    }
   
    private ListNode getTail(ListNode head) {
        if (head == null) {
           return null;
        } 
       
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }
}

package linkedlist;

public class LinkedListCycle_II_142 {
    // 看有没有环，设定两个指针，fast和slow，slow一次一步，fast一次两步，
    // 如果fast能绕一圈追上slow，则说明有环
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        // 1. 起点head到交点距离为a，交点到slow(fast)的距离为b，环的长度为len，slow(fast)再次到达交点的距离为c = len - b
        // 2. fast比slow起点前进一个位置，slow走了a + b的距离，fast走了a - 1 + len + b的距离
        // 3. fast走的距离是slow的两倍，所以a - 1 + len + b = 2(a + b) => len = a + b + 1 = b + c => c = a + 1
        // 4. 也就是说，slow要想继续前进到达交点，需要走的距离是c = a + 1, 而起点head到交点的距离是a，这样就找到了slow和head的关系，
        //    那就是当head走到交点了，slow还差一步，也就是slow.next = head.
        while(slow.next != head) {
            slow = slow.next;
            head = head.next;
        }
        return head;
    }
}

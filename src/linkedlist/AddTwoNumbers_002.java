package linkedlist;

/*关键思路：
1. 非空验证
2. 将两个链表中长的的那个设置为result，将短的那个设置为tmp（为了执行这一步，需要写一个方法getLength用来计算链表的长度）
3. 由于遍历会执行result=result.next，这会改变result，所以在设置了result以后一定要有一个ListNode cursor=result来记录最早的result，要知道最后返回也是返回这个cursor
4. 创建一个boolean类型的进位（carry）符变量
5. 先遍历短的tmp，计算过后对每个经过的result赋值，然后再遍历剩下的result，计算过后对每个经过的result赋值。记得进位符不要忘记算进去了
6. 最后一定要有一个对进位符变量的判断，如果进位符到最后还是true，要result.next = new ListNode(1)
7. 最后返回cursor就可以了
*/
public class AddTwoNumbers_002 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        ListNode result = null, tmp = null;
        if (getLength(l1) >= getLength(l2)) {
            result = l1;
            tmp = l2;
        } else {
            result = l2;
            tmp = l1;
        }
        ListNode head = result;
        int sum = 0;
        boolean inc = false;
        while (result.next != null && tmp.next != null) {
            sum = result.val + tmp.val + (inc ? 1 : 0);
            result.val = sum % 10;
            inc = (sum > 9);
            result = result.next;
            tmp = tmp.next;
        }
        sum = result.val + tmp.val + (inc ? 1 : 0);
        inc  = (sum > 9);
        result.val = sum % 10;
        while (result.next != null) {
            result = result.next;
            sum = result.val + (inc ? 1 : 0);
            result.val = sum % 10;
            inc = (sum > 9);
        }
        if (inc) {
            result.next = new ListNode(1);
        }
        return head;
    }
    
    public int getLength(ListNode head) {
        int len = 0;
        ListNode cursor = head;
        while (cursor != null) {
            len ++;
            cursor = cursor.next;
        }
        return len;
    }
}

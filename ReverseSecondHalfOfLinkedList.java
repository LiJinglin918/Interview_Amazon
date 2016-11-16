/*
2->1->3->4->5->6->7->8 变成 2->1->3->4->8->7->6->5 ； 
如果总是为奇数，中间的也要变 5->7->8->6->3->4->2 变成 5->7->8->2->4->3->6 。

思路
设置快慢指针，找到中点
Reverse linked list 四步骤
*/

public static ListNode reverseSecondHalfList(ListNode head) {
    if (head == null || head.next == null)      
        return head;
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    ListNode pre = slow.next;
    ListNode cur = pre.next;
    while (cur != null) {
        pre.next = cur.next;
        cur.next = slow.next;
        slow.next = cur;
        cur = pre.next;
    }
    return head;
}

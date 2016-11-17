/*
插入一个新的节点到一个sorted cycle linkedlist（升序），返回新的节点。给的list节点不一定是最小节点。

所以先要找到最小的点，或者可能需要找到最大的节点。
如果给的节点比最小的数还要小，那么需要插入在最大的节点后面。所以需要考虑两种情况：1，正常插入在两个节点中间；2，插入在最大最小即排序起始处。
注意：可能list中含有duplicate！！！
*/

public class LinkedListInsert {
    public ListNode Solution(ListNode head, int val) {
        // 如果原本head为空，添加新的节点，next指向自己
        if (head == null) {
            ListNode rvalue = new ListNode(val);
            rvalue.next = rvalue;
            return rvalue;
        }

        ListNode cur = head;

        do {
            //如果val的值正好介于两个节点之间，结束循环，等号是有必要的
            if (val <= cur.next.val && val >= cur.val)  break;
            // 如果正好是排序链断开处，break
            if (cur.val > cur.next.val && (val < cur.next.val || val > cur.val))    break;
            // 否则继续往下找
            cur = cur.next;
        } while (cur != head);
         // 循环直到又到head

        //插入新节点
        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next = newNode;
        return newNode;
    }
}

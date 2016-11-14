/*
Given a linked list, swap every two adjacent nodes and return its head.
For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.
Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = head;
        ListNode pre = dummyHead;
        while (p != null && p.next != null) {
            ListNode q = p.next;
            ListNode r = p.next.next;
            
            pre.next = q;                                   // Note: do not lose linkage.
            p.next = r;
            q.next = p;
            pre = p;
            p = r;
        }
        return dummyHead.next;
    }
}

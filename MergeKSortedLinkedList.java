/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// PQ: 一个基于优先级堆的无界优先级队列。优先级队列的元素按照其自然顺序进行排序，或者根据构造队列时提供的 Comparator 进行排序

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        });
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        for (ListNode node : lists) {
            if (node != null)
                pq.add(node);
        }
        while (!pq.isEmpty()) {
            ListNode listNext = pq.poll();          // the smallest element
            p.next = listNext;                      
            p = p.next;                             
            listNext = listNext.next;               // point to the ListNode next to the smallest element
            if (listNext != null)
                pq.add(listNext);
        }
        p.next = null;
        return dummyHead.next;
    }
}

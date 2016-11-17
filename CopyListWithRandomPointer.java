/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
Return a deep copy of the list.
*/
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
/* 
利用HashMap,key存原先的list每一个结点,value存copy的newList的每一个结点. 第一遍遍历并创建next, 第二遍再加random pointer. 
即：hm:       key               value
              head             newHead    <- p2
      p1 ->   head.next        head.next (创建这一个结点，并利用p2与newHead连接)
*/


public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return head;
        HashMap<RandomListNode, RandomListNode> hm = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.label);
        hm.put(head, newHead);
        RandomListNode p1 = head.next;
        RandomListNode p2 = newHead;
        while(p1 != null) {
            RandomListNode newNode = new RandomListNode(p1.label);
            hm.put(p1, newNode);
            p2.next = newNode;
            p2 = newNode;
            p1 = p1.next;
        }
        p1 = head;
        p2 = newHead;
        while(p1 != null) {
            p2.random = hm.get(p1.random);
            p2 = p2.next;
            p1 = p1.next;
        }
        return newHead;
    }
}

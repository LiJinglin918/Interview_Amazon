/*
Given a singly linked list, determine if it is a palindrome.
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
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        int count = 0;
        ListNode p = head;
        
        while (p != null) {
            count++;
            p = p.next;
        }
        int[] a = new int[count];
        p = head;
        for (int i = 0; i < count; i++) {
            a[i] = p.val;
            p = p.next;
        }
        for (int i = 0; i < count / 2; i++) {
            if (a[i] != a[count - i - 1])
                return false;
        }
        return true;
    }
}

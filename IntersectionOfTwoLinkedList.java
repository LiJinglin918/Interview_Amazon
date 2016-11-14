/*
Write a program to find the node at which the intersection of two singly linked lists begins.
For example, the following two linked lists:
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.
Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) 
            return null;
        HashSet<ListNode> hs = new HashSet<>();
        ListNode tempA = headA;
        ListNode tempB = headB;
        
        while (tempA != null) {
            hs.add(tempA);
            tempA = tempA.next;
        }
        while (tempB != null) {
            if (!hs.contains(tempB))
                tempB = tempB.next;
            else
                return tempB;
        }
        return null;
    }
	
	
/*----------------------------------------------------------------*/

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int lenA = 0, lenB = 0;
        ListNode p1 = headA, p2 = headB;
        while (p1 != null) {
            lenA++;
            p1 = p1.next;
        }
        while (p2 != null) {
            lenB++;
            p2 = p2.next;
        }
        p1 = headA;
        p2 = headB;
        if (lenA >= lenB) {
            int gap = lenA - lenB;
            while (gap-- > 0) 
                p1 = p1.next;
        } else {
            int gap = lenB - lenA;
            while (gap-- > 0)
                p2 = p2.next;
        }
        while (p1 != null && p2 != null) {
            if (p1.equals(p2))
                return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}


/*==============================================================*/

// 变形，两个array. 相同的元素返回一个。
/*
Given two arrays, write a function to compute their intersection.
Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
Note:
Each element in the result must be unique.
The result can be in any order.
*/

import java.util.*;
public class IntersectionOfTwoArrays {
	public static void main(String[] args) {
		int[] num1 = {1,2,3,4,5};
		int[] num2 = {2,3,4};
		int[] res = new IntersectionOfTwoArrays().intersection(num1, num2);
		System.out.println(res[0] + ", " + res[1] + ", " + res[2]);
	}
	public int[] intersection(int[] nums1, int[] nums2) {
		
		HashSet<Integer> hs = new HashSet<>();
		if (nums1 == null || nums2 == null)
			return null;
		for (Integer i : nums1) {
			if (!hs.contains(i))
				hs.add(i);
		}
		List<Integer> list = new ArrayList<>();
		for (Integer i : nums2) {
			if (hs.contains(i) && !list.contains(i))
				list.add(i);
		}
		int size = list.size();
		int[] res = new int[size];
		for (int i = 0; i < size; i++) {
			res[i] = list.get(i);
		}
		return res;
	}
}

/*==============================================================*/

// 变形。两个array。 相同的元素有几个返回几个。
/*
Given two arrays, write a function to compute their intersection.
Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, 
and the memory is limited such that you cannot load all elements into the memory at once?
*/

import java.util.*;
public class IntersectionOfTwoArraysII {
	public static void main(String[] args) {
		int[] num1 = {1};
		int[] num2 = {1,1};
		int[] res = new IntersectionOfTwoArraysII().intersect(num1, num2);
		System.out.println(res[0] + ", " + res[1]);
	}
	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null)
			return null;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (Integer i : nums1) {
			if (!hm.containsKey(i))
				hm.put(i, 1);
			else
				hm.put(i, hm.get(i) + 1);
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (Integer i : nums2) {
			if (hm.containsKey(i) && hm.get(i) != 0) {
				list.add(i);
				hm.put(i, hm.get(i) - 1);
			}
		}
		int size = list.size();
		int[] res = new int[size];
		for (int i = 0; i < size; i++) {
			res[i] = list.get(i);
		}
		return res;
	}
}

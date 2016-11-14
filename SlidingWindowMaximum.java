/*
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
You can only see the k numbers in the window. Each time the sliding window moves right by one position.
For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].
Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
Follow up:
Could you solve it in linear time?
Hint:
How about using a data structure such as deque (double-ended queue)?
The queue size need not be the same as the window’s size.
Remove redundant elements and the queue should store only elements that need to be considered.
*/
/*
利用双向链表LinkedList存储index, API有peekFirst, peekLast, removeFirst, removeLast, addLast。
LinkedList按照其index代表的数降序排列
前k个数只存储前面数值较大的。新数来时，deque后边的小于新数的数全部删掉（进而保证降序排列）
大于窗口，即deque最左边存储的index == i - k时，删掉最前面的。
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3。
*/ 
// 也可利用PQ做。PQ存储k个升序排列。每次窗口移动，移除窗口第一个元素。


// deque. O(N)
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];
        LinkedList<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length + 1 - k];               // The result contains several max numbers
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k)
                deque.removeFirst();
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.removeLast();
            deque.addLast(i);
            if (i >= k - 1)
                res[i - k + 1] = nums[deque.peekFirst()];      // deque第一个则为最大
        }
        return res;
    }

/*==========================================================================================================*/
	
	
    public int[] maxSlidingWindow2(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return new int[0];
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int[] res = new int[nums.length + 1 - k];
		for (int i = 0; i < nums.length; i++) {
			if (i >= k)
				pq.remove(nums[i - k]);
			pq.add(nums[i]);
			if (i + 1 >= k)
				res[i + 1 - k] = pq.peek();
		}
		return res;
	}
}

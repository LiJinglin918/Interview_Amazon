/*
Zigzag Iterator

Given two 1d vectors, implement an iterator to return their elements alternately.
For example, given two 1d vectors:
v1 = [1, 2]
v2 = [3, 4, 5, 6]
By calling next repeatedly until hasNext returns false, 
the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
Clarification for the follow up question - Update (2015-09-18):
The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:
[1,2,3]
[4,5,6,7]
[8,9]
It should return [1,4,8,2,5,9,3,6,7].
*/

// Iterator 的练习。List<Iterator<Integer>> list来存储两个Iterator, 用count = (count + 1) % list.size()来循环。
// 返回next()之后，如果此Iterator无元素，则删除。

import java.util.*;
public class ZigzagIterator {
	List<Iterator<Integer>> list = new ArrayList<>();
	int count = 0;
	public ZigzagItertor(List<Integer> v1, List<Integer> v2) {
		if (!v1.isEmpty())
			list.add(v1.iterator());
		if (!v2.isEmpty())
			list.add(v2.iterator());
	}
	
	public int next() {
		int x = list.get(count).next();
		if (!list.get(count).hasNext())
			list.remove(count);
		else
			count++;
		if (list.size() != 0)
			count = count % list.size();
		return x;
	}
	
	public boolean hasNext() {
		return !list.isEmpty();
	}
}

/** 
 * Your ZigzagIterator object will be instantiated and called as such: 
 * ZigzagIterator i = new ZigzagIterator(v1, v2); 
 * while (i.hasNext()) v[f()] = i.next(); 
 */ 

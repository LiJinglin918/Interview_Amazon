/*
给你一个整数数组，里面所有元素都出现偶数次except一个元素出现奇数次。找出这个出现奇数次的元素

*/
public class Solution {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,5,4,3,2,6,6,6,6};
		System.out.println(new Solution().printOddEven(a));
	}
	public int printOddEven(int[] a) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (!hm.containsKey(a[i]) || hm.get(a[i]) == 0) {
				hm.put(a[i], 1);
			}
			else {
				hm.put(a[i], 0);
			}
		}
		for (int i : hm.keySet()) {
			if (hm.get(i) == 1)
				return i;
		}
		return -1;
	}
}

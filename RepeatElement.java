// 找出出现次数最多的element

public class Solution {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,5,4,3,2,6,6,6,6, 5, 1,2,2,2,2,2,3,4};
		System.out.println(new Solution().RepeatElement(a));
	}
	public int RepeatElement(int[] a) {
		if (a == null || a.length <= 0)
			return -1;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (!hm.containsKey(a[i])) {
				hm.put(a[i], 1);
			}
			else {
				hm.put(a[i], hm.get(a[i]) + 1);
			}
		}
		int max = 1;
		int res = 0;
		for (int i : hm.keySet()) {
			if (hm.get(i) > max) {
				max = hm.get(i);
				res = i;
			}
		}
		return res;
	}
}

// 2与1的区别是，2中有重复,有计数，用hashmap
/*
 * 用hm计数，然后记录第一个list里面的所有string。
 * 之后用temp，如果都有，更新temp
 * 最后hm = temp, 每一次更新为上一个list
 * 将hm中的key都放入res
 */

import java.util.*;
public class SameElementII {
	public List<String> find (List<List<String>> list) {
		List<String> res = new ArrayList<>();
		if (list == null || list.size() == 0)
			return res;
		HashMap<String, Integer> hm = new HashMap<>();
		// 将第一个list的所有元素放进第一个hm
		for (String s : list.get(0)) {
			hm.put(s, hm.containsKey(s)? hm.get(s) + 1 : 1);
		}
		for (int i = 1; i < list.size(); i++) {
			HashMap<String, Integer> temp = new HashMap<>();
			for (String s : list.get(i)) {
				if (hm.containsKey(s) && hm.get(s) > 0) {
					temp.put(s, temp.containsKey(s)? temp.get(s) + 1 : 1);
					hm.put(s, hm.get(s) - 1);
				}
			}
			hm = temp;
		}
		for (Map.Entry<String, Integer> entry : hm.entrySet()) {
			for (int i = 0; i < entry.getValue(); i++) {
				res.add(entry.getKey());
			}
			
		}
		return res;
	}
}

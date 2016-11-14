/*
Given an array of strings, group anagrams together.
For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:
[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.
*/

import java.util.*;

public class Solution {
    public static void main(String[] args) {
          String[] strs = { "god", "dog", "dot", "cog", "log", "tod"};
          List<List<String>> res = groupAnagrams(strs);
          System.out.println(res.toString());
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null)
            return res;
        HashMap<String, List<String>> hm = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);						            // Note the usage of new String(char[]), not c.toString()						
            if (hm.containsKey(sorted)) {
            	hm.get(sorted).add(s);
            	System.out.println("1");
            }
            else {
            	List<String> list = new ArrayList<String>();
            	list.add(s);
            	hm.put(sorted, list);
            	System.out.println("2");
            }
        }
        for (String s2 : hm.keySet()) {
            Collections.sort(hm.get(s2));
        	  res.add(hm.get(s2));
        }
    return res;   
    }
}

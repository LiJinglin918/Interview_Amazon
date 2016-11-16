/*
Two Sum Count
Consider case: {3, 2, 4} target = 6, output {3, 3} {2, 4}
算重复的
*/


import java.util.HashMap;
// time O(n), space O(n)
public static int count1(int[] nums, int target) {
           // corner case
    if (nums == null || nums.length < 2) {
        return 0; 
    }
    int cnt = 0;
    HashSet<Integer> hash = new HashSet<Integer>();
    for (int i = 0; i < nums.length; i++) {
        hash.add(nums[i]);
    }
    for (int i = 0; i < nums.length; i++) {
        if (hash.contains(target - nums[i])) {
            cnt++; 
        }
    }
    return cnt; 
}

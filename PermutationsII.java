/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.
For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/
// 与Permutations I不同在于这次有duplicate. 
// 当前元素如果与前一个元素相同，则前面的数必须visited了当前数才能使用。

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        helper (res, nums, new boolean[nums.length], new ArrayList<Integer>());
        return res;
    }
    
    private void helper(List<List<Integer>> res, int[] nums, boolean[] visited, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                continue;
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                helper(res, nums, visited, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}

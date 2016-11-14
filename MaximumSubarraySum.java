/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
*/
// DP. sum[i]存储要么当前的数与前面的sum[i - 1]相加之后，更大的；要么取当前数比前面的sum[i - 1]大、重新开始自立门户的。

public class Solution {
    public int maxSubArray(int[] nums) {
        int[] sum = new int[nums.length];
        int res = nums[0];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = Math.max(sum[i - 1] + nums[i], nums[i]);
            res = Math.max(res, sum[i]);
        }
        return res;
    }
}

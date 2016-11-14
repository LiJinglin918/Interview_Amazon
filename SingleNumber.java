public class Solution {
    public int singleNumber(int[] nums) {
        //异或：相同为0，不同为1
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            result = result ^ nums[i]; //相同的数异或为0，遍历结束后就剩下那个single number了
        }
        return result;
    }
}

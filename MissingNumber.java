/*
/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
For example,
Given nums = [0, 1, 3] return 2.
*/
*/

public class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0, i; 
        //用异或，将index和value都同时异或，成对的index和value在异或以后就为0，也就是相互抵消了，剩下的再与for循环后的i异或就是结果
        for(i = 0; i < nums.length; i++){ 
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }
}
/*--------------------------------------------------------------*/

public class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = (1 + len) * len / 2;
        for (int i = 0; i < len; i++) {
            sum = sum - nums[i];
        }
        return sum;
    }
}

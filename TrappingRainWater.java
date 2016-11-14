/*
Given n non-negative integers representing an elevation map where the width of each bar is 1. 
Compute how much water it is able to trap after raining.
For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/
// 用left[height.length]和right[height.length]存储每一个i的左边最高（从左向右遍历）和右边最高（需要从右向左遍历）。形成凹型。

public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int res = 0;
        int left[] = new int[height.length];
        int right[] = new int[height.length];
        
        left[0] = height[0];                                          // 从左向右，left[]每一个index存储它之前最高的左边
        int max = left[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(max, height[i]);
            max = left[i];
        }
        
        right[height.length - 1] = height[height.length - 1];         // 从右向左，right[]每一个index存储它之后最高的右边
        max = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(max, height[i]);
            max = right[i];
        }
        
        for (int i = 1; i < height.length - 1; i++) {                 // height[]每一个index计算形成凹型之后，与最短板形成的面积
            int realHeight = Math.min(left[i], right[i]) - height[i];
            if (realHeight > 0)
                res = res + realHeight;
        }
        return res;
    }
}

/*===============================================================*/


public class Solution {
    public int trap(int[] height) {
        int secheight = 0;
        int left = 0;
        int right = height.length - 1;
        int s = 0;
        while(left < right){
            if(height[left] < height[right]){
                secheight = Math.max(secheight, height[left]);
                s += secheight - height[left];
                left++;
            }
            else{
                secheight = Math.max(secheight, height[right]);
                s += secheight - height[right];
                right--;
            }
        }
        return s;
    }
}

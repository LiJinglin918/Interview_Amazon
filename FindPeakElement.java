/*
search in increasing and then decreasing array。实际就是找peak，然后分成左右两个继续二分

*/
public class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while(low < high) {
            mid = low + (high-low)/2;
            if(nums[mid] < nums[mid+1]) low = mid+1;
            else high = mid;
        }
        return low;
    }
}


/*=======================================================*/


/*
A peak element is an element that is greater than its neighbors.
Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
You may imagine that num[-1] = num[n] = -∞.
For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
*/

public class Solution {
    public int findPeakElement(int[] nums) {
        
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 0;
        if (nums[1] < nums[0])
            return 0;
        if (nums[nums.length - 2] < nums[nums.length - 1])
            return nums.length - 1;
            
        int low = 1, high = nums.length - 2;
        
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            else if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            }
            else if (nums[mid] < nums[mid - 1]) {
                high = mid;
            }
        }
        return low;                                                       // when the low == high, return low
    }
    
}

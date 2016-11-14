// 41. Search in rotated array
/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.
*/

public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null)
            return -1;
        if (nums.length == 1)
        	return nums[0] == target? 0 : -1;
        int low = 0, high = nums.length - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[high]) {
                if (target < nums[high] || target > nums[mid])
                    low = mid + 1;
                else if (target < nums[mid] && target > nums[high])
                    high = mid - 1;
                else if (target == nums[mid])
                    return mid;
                else
                    return high;
            }
            else if (nums[mid] < nums[high]) {
                if (target < nums[mid] || target > nums[high])
                    high = mid - 1;
                else if (target > nums[mid] && target < nums[high])
                    low = mid + 1;
                else if (target == nums[mid])
                    return mid;
                else 
                    return high;
            }
            else {
            	if (nums[mid] == target)
            	    return mid;
            	else
            	    low = mid + 1;                                    // Note the usage of this to avoid TLE because not found
            }
        }
        return -1;
    }
}

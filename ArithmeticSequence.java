/* 
Given an array, return the number of possible arithmetic sequence.
给一个数组，返回可能的等差数列个数。
连续三个数才能成为等差数列。
*/

public static int getLAS(int[] A){
    // Time: O(n)
    // Space: O(1)
    if (A.length < 3) return 0;

    int res = 0;
    int diff = Integer.MIN_VALUE;
    int count = 0;
    int start = 0;
    for (int i = 1; i < A.length; i++){
        int currDiff = A[i] - A[i - 1];
        if (diff == curDiff){
            // 比较难想到的一步！！！
            count += i - start - 1 > 0 ? i - start - 1 : 0;
        } else {
            start = i - 1;
            diff = currDiff;
            res += count;
            count = 0;
        }
    }
    res += count;
    return res;
}


/*=========================================================================================================*/

public class ArithmeticSlice {
    public int Solution(int[] array) {
        if (array == null || array.length < 3)  return 0;
        int rvalue = 0, gap = array[1] - array[0], length = 2;
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i+1] - array[i] == gap)   length++;
            else {
                gap = array[i+1] - array[i];
                if (length >= 3)
                    rvalue += (length - 1) * (length - 2) / 2;
                //防止溢出？
                if (rvalue > 1000000000)    return -1;
                length = 2;
            }
        }
        if (length >= 3)
            rvalue += (length - 1) * (length - 2) / 2;
        return rvalue > 1000000000 ? -1 : rvalue;
    }
}

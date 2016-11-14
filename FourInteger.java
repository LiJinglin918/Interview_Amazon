/*
Given four integers, make F(S) = abs(S[0]-S[1])+abs(S[1]-S[2])+abs(S[2]-S[3]) to be largest.
*/


import java.util.Arrays;

public class FourInteger {
    public int[] Solution(int A, int B, int C, int D) {
        int[] rvalue = new int[4];
        rvalue[0] = A;
        rvalue[1] = B;
        rvalue[2] = C;
        rvalue[3] = D;
        Arrays.sort(rvalue);
        
        // 先sort, 再交换
        swap(rvalue, 0, 1);
        swap(rvalue, 2, 3);
        swap(rvalue, 0, 3);
        return rvalue;
    }
    
    // 实际上就是交换
    private void swap(int[] array, int i, int j) {
        array[i] ^= array[j];
        array[j] ^= array[i];
        array[i] ^= array[j];
    }
}

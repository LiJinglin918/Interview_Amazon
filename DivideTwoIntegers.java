/*
Divide two integers without using multiplication, division and mod operator.
If it is overflow, return MAX_INT.
*/
/*
最直观的方法是，用被除数逐个的减去除数，直到被除数小于0。这样做会超时。
那么如果每次不仅仅减去1个除数，计算速度就会增加，
但是题目不能使用乘法，因此不能减去k*除数，我们可以对除数进行左移位操作，
这样每次相当于减去2^k个除数，
如何确定k呢，只要使 (2^k)*除数 <=  当前被除数 <(2^(k+1))*除数.
http://www.cnblogs.com/TenosDoIt/p/3795342.html
这里必须将原来的dividend和divisor转化成unsigned long long类型。不然divisor左移时可能会变成负数从而陷入死循环。
*/

public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;
        if (dividend == 0)
            return 0;
        if (divisor == 1)
            return dividend;
        if (divisor == -1)
            return dividend == Integer.MIN_VALUE? Integer.MAX_VALUE : -dividend;
        boolean neg = ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0));
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        int res = 0;
        for (int bit = Integer.SIZE - 1; bit >= 0 && ldividend >= ldivisor; bit--) {
            if (ldividend >= (ldivisor << bit)) {
                res += 1 << bit;                                                          // add the "1" in the certain bit
                ldividend -= ldivisor << bit;
            }
        }
        return neg? -res : res;
    }
}

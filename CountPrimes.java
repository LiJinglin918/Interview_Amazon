/*
Description:
Count the number of prime numbers less than a non-negative number, n.
*/
// 设定每一个数都为质数。遍历从2开始（忽略已变成非质数的数），把某一个数与2、3、5、7、9...的乘积的数字都变为非质数。返回质数。

public class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < n; i++) {
            if (isPrime[i])
            for (int j = 2 * i; j < n; j = j + i)       // note the usage of j = j + i, 即j == 2 * i + i == 3 * i, 以及5i, 7i, 9i等
                isPrime[j] = false;
        }
        // 删除完开始数
        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrime[i])
                count++;
        return count;
    }
}

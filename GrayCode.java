/*
The gray code is a binary numeral system where two successive values differ in only one bit.
Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.
For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
*/

// 0, 1, 11, 10/ 110, 111, 101, 100/ 1100, 1101, 1111, 1110, 1010, 1011, 1001, 1000/... n increase, 1 << n - 1 add then backtracking.

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            res.add(0);
            return res;
        }
        res.add(0);
        res.add(1);
        for (int i = 2; i <= n; i++) {
            int addNumber = 1 << (i - 1);
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(res.get(j) + addNumber);
            }
        }
        return res;
    }
}

/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
For example,
Given n = 3, there are a total of 5 unique BST's.
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/
/* 
卡塔兰数。BST左子树都小于根节点，右子树都大于根节点。
以i为根节点的树，其左子树由[0, i-1]构成， 其右子树由[i+1, n]构成。所以是左子数与右子树相乘关系
Count[3] = Count[0]*Count[2]  (1为根的情况) （左子数看作是空子树）
         + Count[1]*Count[1]  (2为根的情况)
         + Count[2]*Count[0]  (3为根的情况)
         
同理，Count[4] = Count[0] * Count[3] (1为根的情况)
               + Count[1] * Count[2] (2为根的情况) （左边有1，右边有3、4）
               + Count[2] * Count[1] (3为根的情况)
               + Count[3] * Count[0] (4为根的情况)
所以，Count[t] = ∑ Count[k] * Count[t - k - 1] (0<=k<=i-1)。
*/

public class Solution {
    public int numTrees(int n) {
        if (n == 0 || n == 1)
            return 1;
        int[] C = new int[n + 1];
        C[0] = 1;
        for (int t = 1; t <= n; t++) {
            for (int i = 0; i <= t - 1; i++) {
                C[t] += C[i] * C[(t - 1) - i];
            }
        }
        return C[n];
    }
}

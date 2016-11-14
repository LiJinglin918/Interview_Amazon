/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/
// DP. 由下向上推导，取相邻最小值加上本身存储在dp中，dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle(i, j)
// 可简化为一位数组（因为每行找最小值的过程只进行一次，可覆盖）



public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1)
            return triangle.get(0).get(0);
        int[] dp = new int[triangle.size()];
        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
            dp[i] = triangle.get(triangle.size() - 1).get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

	
	/*-----------------------------------------------------------------*/
	
	
public int minimumTotal2(List<List<Integer>> triangle) {
	if (triangle == null)
		return 0;
	for (int i = triangle.size() - 2; i >= 0; i--) {
		for (int j = 0; j < triangle.get(i).size(); j++) {
			triangle.get(i).set(j, triangle.get(i).get(j) +
			Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
		}
	}
	return triangle.get(0).get(0);
	}
}

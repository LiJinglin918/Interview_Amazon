/*
Given an index k, return the kth row of the Pascal's triangle.
For example, given k = 3,
Return [1,3,3,1].
*/
/*
找规律：原先都为0，i相应的地方变为1，然后另设定指针j从右(j == i - 1)向左(j > 0)，in-place取代原先的数儿变为与前面一个数之和。
i == 0:   1 0 0 0 
i == 1:   1 1 0 0
i == 2:   1 1 1 0
          1 2 1 0
          
i == 3:   1 2 1 1
          1 2 3 1
          1 3 3 1
*/

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            res.add(0);
        }
        res.set(0, 1);
        for (int i = 1; i <= rowIndex; i++) {
            res.set(i, 1);
            for (int j = i - 1; j > 0; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }
        return res;
    }
}

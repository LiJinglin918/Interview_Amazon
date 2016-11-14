public class Solution {
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        int pre = 1;
        int cur = 1;
        int m = 0;
        for(int i = 1; i < n; i++){
            m = pre + cur;
            pre = cur;
            cur = m;
        }
        return m;
    }
}

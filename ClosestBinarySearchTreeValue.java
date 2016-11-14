/*
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
*/
// 最近的node是：如果target < root.val, 是左子数或者根节点，如果target > root.val, 是右子树或根节点。

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int closestValue(TreeNode root, double target) {
         int ret = root.val;   
        while(root != null){
			// 找最closed的
            if(Math.abs(target - root.val) < Math.abs(target - ret)){
                ret = root.val;
            }      
            root = root.val > target? root.left: root.right;
        }     
        return ret;
    }
}

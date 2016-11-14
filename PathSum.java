/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
*/ 
 
 // recursive
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.val == sum && (root.left == null && root.right == null)){
            return true;
        }
        return (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));
    } 
}

/*============================================================*/

// not recursive, using stack



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 **/
 
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        stack.push(root);
        sumStack.push(0);
        
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            int summary = sumStack.pop() + n.val;
            
            if (n.left == null && n.right == null && summary == sum)
                return true;
            
            if (n.left != null) {
                stack.push(n.left);
                sumStack.push(summary);                          // store the summary of last level
            }
            
            if (n.right != null) {
                stack.push(n.right);
                sumStack.push(summary);
            }
        }
        return false;
    }
}

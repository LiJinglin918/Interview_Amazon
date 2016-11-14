/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
Calling next() will return the next smallest number in the BST.
Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    public Stack<TreeNode> stack = new Stack<>();                         // Note the usage of public Stack
    public BSTIterator(TreeNode root) {
        
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (stack.isEmpty())
            return false;
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode res = new TreeNode(0);
        if (!stack.isEmpty()) {
            res = stack.pop();
            if (res.right != null) {
               TreeNode temp = res.right;
               while (temp != null) {
                   stack.push(temp);
                   temp = temp.left;
               }
            }
        }
        return res.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

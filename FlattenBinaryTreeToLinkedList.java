/*
Given a binary tree, flatten it to a linked list in-place.
For example,
Given
         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// not recursive, use stack
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node.right != null)
                stack.push(node.right);
                
            if (node.left != null) {
                node.right = node.left;
                node.left = null;
            }
            else if (!stack.isEmpty()) {
                node.right = stack.pop();
            }
            node = node.right;
        }
    }
	
/*==========================================================================================================*/
// recursive
	
public class Solution {
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
	    
        root.right = prev;		// previous is the previous root, the subtree's root
        root.left = null;
        prev = root;			
    }
}
	
/*====================================================================================================*/
// rightmost
	
    public void flatten2(TreeNode root) {
	if (root == null)
		return;
	while (root.left != null || root.right != null) {
		if (root.left == null)
			root = root.right;
		else {
			TreeNode rightMost = root.left;
			TreeNode right = root.left;
			TreeNode temp = root.right;
			while (rightMost.right != null) {
				rightMost = rightMost.right;
			}
			rightMost.right = temp;
			root.right = right;
			root.left = null;
			root = root.right;
		}
	}
}
}

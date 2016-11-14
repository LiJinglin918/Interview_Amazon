/*
比如说
          a
   b          c
                   d

你要变成

d 
    c      b
        a
head node 就是 b d

*/

import java.util.*;
public class ReverseBinaryTree {
	public List<TreeNode> upSideDown(TreeNode root) {
		List<TreeNode> res = new ArrayList<>();
		if (root == null)
			return res;
		dfs(root, res);
			
		root.left = null;
		root.right = null;
		return res;
	}
	public void dfs(TreeNode root, List<TreeNode> res) {
		if (root == null)
			return;
		else if (root.left == null && root.right == null) {
			res.add(root);
			return;
		}
		if (root.right != null) {
			dfs(root.right, res);
			root.right.right = root;
		}
		if (root.left != null) {
			dfs(root.left, res);
			root.left.left = root;
		}
	}
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
}

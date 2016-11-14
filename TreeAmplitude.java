/*
求从root到leaf，其中一条路上，最大值和最小值的差。
*/

/*
例子:
          11
        /   \
       4     9
      / \   / \ 
     1   5 55 66

返回 57. 
*/


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode (int x) {
		val = x;
	}
}
public class TreeAmplitude {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(11);
		TreeNode l = new TreeNode(4);
		root.left = l;
		TreeNode r = new TreeNode(9);
		root.right = r;
		TreeNode ll = new TreeNode(1);
		l.left = ll;
		TreeNode lr = new TreeNode(5);
		l.right = lr;
		TreeNode rl = new TreeNode(55);
		r.left = rl;
		TreeNode rr = new TreeNode(66);
		r.right = rr;
		System.out.println(new TreeAmplitude().Solution(root));
	}
	public int Solution(TreeNode root) {
		if (root == null)
			return 0;
		return helper(root, root.val, root.val);
	}
	public int helper(TreeNode root, int min, int max) {
		if (root == null)
			return max - min;
		if (root.val < min)
			min = root.val;
		if (root.val > max)
			max = root.val;
		return Math.max(helper(root.left, min, max), helper(root.right, min, max));
	}
}

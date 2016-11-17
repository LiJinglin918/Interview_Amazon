/*
LC的题目是左上角到右下角的path.此题是求解BST的左子数到右子树的最小path. (最小的路径，即左右没有子树的叶子之间的距离)
*/
public class PathSum {
    public int Solution(TreeNode root) {
        if (root == null)   return 0;
        if (root.left != null && root.right == null)
            return Solution(root.left) + root.val;        // 一旦有到没有子树的叶子，立刻返回，所以是最短的
        if (root.left == null && root.right != null)
            return Solution(root.right) + root.val;
        return Math.min(Solution(root.left), Solution(root.right)) + root.val;
    }
}

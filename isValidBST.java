    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValid(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
	
/*======================================================================*/	
	
	
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return isSubLeftLessThan(root.left, root.val) && isSubRightGreaterThan(root.right, root.val) && isValidBST(root.left) && isValidBST(root.right);
    }
    private boolean isSubLeftLessThan(TreeNode p, int value) {
        if (p == null)
            return true;
        return p.val < value && isSubLeftLessThan(p.left, value) && isSubLeftLessThan(p.right, value);
    }
    private boolean isSubRightGreaterThan(TreeNode p, int value) {
        if (p == null)
            return true;
        return p.val > value && isSubRightGreaterThan(p.left, value) && isSubRightGreaterThan(p.right, value);
    }

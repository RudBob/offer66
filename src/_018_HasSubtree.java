public class _018_HasSubtree {
    public boolean HasSubtree(TreeNode root1, TreeNode subRoot) {
        if (subRoot != null && root1 != null) {
            if (root1.val == subRoot.val) {
                if (hasSameTree(root1, subRoot)) {
                    return true;
                }
            }
            return HasSubtree(root1.left, subRoot) || HasSubtree(root1.right, subRoot);
        }
        return false;
    }

    private boolean hasSameTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return hasSameTree(root1.left, root2.left) && hasSameTree(root1.right, root2.right);
        }
        return false;
    }
}

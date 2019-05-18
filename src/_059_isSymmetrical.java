public class _059_isSymmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        //
        return isSymmetrical(pRoot, pRoot);
    }

    private boolean isSymmetrical(TreeNode pRoot, TreeNode pRoot1) {
        if (pRoot != null && pRoot1 != null) {
            if (pRoot.val != pRoot1.val) {
                return false;
            }
        } else if (pRoot != null || pRoot1 != null) {
            return false;
        } else {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot1.right) && isSymmetrical(pRoot.right, pRoot1.left);
    }
}

public class _027_convertTreeToListNond {
        public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        // root 的 root.left指向 ：最右
        // root 的 root.right指向: 最左
        TreeNode left = pRootOfTree.left;
        TreeNode right = pRootOfTree.right;
        TreeNode head = getLeft(pRootOfTree);
        // 左侧为左侧的最左
        pRootOfTree.left = getRight(left);
        Convert(left);
        if (pRootOfTree.left != null) {
            pRootOfTree.left.right = pRootOfTree;
        }
        pRootOfTree.right = getLeft(right);
        Convert(right);
        if (pRootOfTree.right != null) {
            pRootOfTree.right.left = pRootOfTree;
        }
        return head;
    }

    private TreeNode getRight(TreeNode right1) {
        TreeNode right = right1;
        if (right == null) {
            return null;
        }
        while (right.right != null) {
            right = right.right;
        }
        return right;
    }

    private TreeNode getLeft(TreeNode left1) {
        TreeNode left = left1;
        if (left == null) {
            return null;
        }
        while (left.left != null) {
            left = left.left;
        }
        return left;
    }
}

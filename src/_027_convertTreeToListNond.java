/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class _027_convertTreeToListNond {
    /**
     * 左右子树指针转为：前指针，后指针
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        // 保存左右节点引用
        TreeNode left = pRootOfTree.left;
        TreeNode right = pRootOfTree.right;
        // 链表头为：最左侧节点
        TreeNode head = getLeftMost(pRootOfTree);
        // 左侧为左侧的最左
        // root 的 root.left指向: 最右
        pRootOfTree.left = getRightMost(left);
        // 对左子节点递归
        Convert(left);
        if (pRootOfTree.left != null) {
            pRootOfTree.left.right = pRootOfTree;
        }
        // root 的 root.right指向 ：最左
        pRootOfTree.right = getLeftMost(right);
        // 递归右子节点
        Convert(right);
        if (pRootOfTree.right != null) {
            pRootOfTree.right.left = pRootOfTree;
        }
        return head;
    }

    /**
     * 得到最右边的节点
     */
    private TreeNode getRightMost(TreeNode root) {
        TreeNode rightMost = root;
        if (rightMost == null) {
            return null;
        }
        while (rightMost.right != null) {
            rightMost = rightMost.right;
        }
        return rightMost;
    }

    /**
     *
     */
    private TreeNode getLeftMost(TreeNode root) {
        TreeNode leftMost = root;
        if (leftMost == null) {
            return null;
        }
        while (leftMost.left != null) {
            leftMost = leftMost.left;
        }
        return leftMost;
    }
}

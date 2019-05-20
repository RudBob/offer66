/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 */
public class _018_HasSubtree {
    /**
     * 几乎所有树的问题都是递归的问题。
     * 对于每个节点都要判断是否与目标子树节点相同。
     */
    public boolean HasSubtree(TreeNode root1, TreeNode subRoot) {
        if (subRoot != null && root1 != null) {
            if (root1.val == subRoot.val) {
                // 是否是同一个树
                if (hasSameTree(root1, subRoot)) {
                    return true;
                }
            }
            // 对每个节点都要进行上述过程。
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
        // 对每个节点都要进行上述过程
        if (root1.val == root2.val) {
            return hasSameTree(root1.left, root2.left) && hasSameTree(root1.right, root2.right);
        }
        return false;
    }
}

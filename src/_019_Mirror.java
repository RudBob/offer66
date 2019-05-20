/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */

/**
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */
public class _019_Mirror {
    /**
     *  每个节点都要翻转
     */
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        // swap，交换左右节点。
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        // 遍历每个节点
        Mirror(root.left);
        Mirror(root.right);
    }
}

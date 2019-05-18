public class _019_Mirror {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        Mirror(root.left);
        Mirror(root.right);
    }
}

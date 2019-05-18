public class _063_KthNode {
    int i = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        //中序遍历次序与大小次序相同
        TreeNode res = KthNode(pRoot.left, k);
        if (res != null) {
            return res;
        }
        i++;
        if (k == i) {
            return pRoot;
        }
        res = KthNode(pRoot.right, k);
        return res;
    }
}

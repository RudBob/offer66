public class _006_reConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        // 真正有用的不是前序数组，而是数组在前序中出现的次序。
        int[] index = new int[pre.length];
        // 找到前序对应在中序中的顺序,使用index数组保存.
        for (int i = 0; i < pre.length; i++) {
            for (int j = 0; j < in.length; j++) {
                if (pre[i] == in[j]) {
                    index[j] = i;
                }
            }
        }
        TreeNode root = reConstructBinaryTree(in, index, 0, index.length - 1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int[] in, int[] index, int head, int last) {
        if(head > last){
            return null;
        }
        int minIndex = head;
        // 找到目标中序数组中且在前序数组中最靠前的数字.
        for (int i = head + 1; i <= last; i++) {
            if (index[minIndex] > index[i]) {
                minIndex = i;
            }
        }
        // 通过数字生成新节点。
        TreeNode root = new TreeNode(in[minIndex]);
        // 递归处理其左侧数组和右侧数组
        root.left = reConstructBinaryTree(in, index, head, minIndex - 1);
        root.right = reConstructBinaryTree(in, index, minIndex + 1, last);
        return root;
    }
}


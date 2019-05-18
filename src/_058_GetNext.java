public class _058_GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 中序遍历：如果中序遍历右节点的最左节点.
        if (pNode.right != null) {
            return getLeft(pNode.right);
        } else {
            return getFather(pNode);

        }
        // 如果没有右节点，就返回父节点
    }

    private TreeLinkNode getFather(TreeLinkNode pNode) {
        TreeLinkNode father = pNode.next;
        // 如果他是父亲节点的左节点
        if (father == null || father.left == pNode) {
            return father;
        } else {
            // 如果他是父亲节点的右节点，那么返回
            return getFather(father);
        }
    }

    private TreeLinkNode getLeft(TreeLinkNode right) {
        while (right.left != null) {
            right = right.left;
        }
        return right;
    }
}

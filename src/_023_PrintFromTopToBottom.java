import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _023_PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;

        }
        // 写一个ArrayList
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- != 0) {
                TreeNode tempNode = queue.remove();
                res.add(tempNode.val);
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
        }
        return res;
    }
}

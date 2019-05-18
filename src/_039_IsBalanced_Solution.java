import java.util.HashMap;

public class _039_IsBalanced_Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
//        return byMemoMap(root);
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }

    private boolean byMemoMap(TreeNode root) {
        if (root == null) {
            return true;
        }
        HashMap<TreeNode, Integer> memoLen = new HashMap<>();
        memoLen.put(null, 0);
        int leftLen = TreeDepth(root.left, memoLen);
        int RightLen = TreeDepth(root.right, memoLen);
        return Math.abs(leftLen - RightLen) <= 1 && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int TreeDepth(TreeNode root, HashMap<TreeNode, Integer> memoLen) {
        if (root == null) {
            return 0;
        }
        if (memoLen.get(root) == null) {
            memoLen.put(root, Math.max(TreeDepth(root.left, memoLen), TreeDepth(root.right, memoLen)) + 1);
        }
        return memoLen.get(root);
    }
}

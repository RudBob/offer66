import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class _025_FindPath {
    // 深搜
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        // 总路径集合
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        // 每个单一路径
        ArrayList<Integer> path = new ArrayList<>();
        FindPath(root, target, path, paths);
        return paths;
    }

    private void FindPath(TreeNode root, int target,
                          ArrayList<Integer> path, ArrayList<ArrayList<Integer>> paths) {
        if (root == null || target < 0) {
            return;
        }
        // 叶子节点进行判断
        if (root.left == null && root.right == null) {
            // 路径和相同,则保存路径副本。
            if (target == root.val && path != null) {
                // 新建一个ArrayList
                ArrayList<Integer> a = (ArrayList<Integer>) path.clone();
                a.add(root.val);
                paths.add(a);
            }
            return;
        }
        // 深搜，先将节点保存后深搜，然后移除节点
        path.add(root.val);
        FindPath(root.left, target - root.val, path, paths);
        FindPath(root.right, target - root.val, path, paths);
        path.remove(path.size() - 1);
    }
}
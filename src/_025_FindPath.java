import java.util.ArrayList;

public class _025_FindPath {
    // 深搜
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        FindPath(root, target, path, paths);
        return paths;
    }

    private void FindPath(TreeNode root, int target,
                          ArrayList<Integer> path, ArrayList<ArrayList<Integer>> paths) {
        if (root == null || target < 0) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (target == root.val) {
                // 新建一个ArrayList
                ArrayList<Integer> a = (ArrayList<Integer>) path.clone();
                a.add(root.val);
                paths.add(a);
            }
            return;
        }
        path.add(root.val);
        FindPath(root.left, target - root.val, path, paths);
        path.remove(path.size() - 1);

        path.add(root.val);
        FindPath(root.right, target - root.val, path, paths);
        path.remove(path.size() - 1);
    }
}
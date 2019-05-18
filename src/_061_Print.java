import java.util.*;

public class _061_Print {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null){
            return res;
        }
        // 使用双Stack来完成翻转
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(pRoot);
        while (s1.size() != 0 || s2.size() != 0) {
            ArrayList<Integer> r = new ArrayList<>();
            if (s1.size() != 0) {
                while (s1.size() != 0) {
                    TreeNode a = s1.pop();
                    r.add(a.val);
                    if (a.left != null) {
                        s2.push(a.left);
                    }
                    if (a.right != null) {
                        s2.push(a.right);
                    }
                }
            } else {
                while (s2.size() != 0) {
                    TreeNode a = s2.pop();
                    r.add(a.val);
                    if (a.right != null) {
                        s1.push(a.right);
                    }
                    if (a.left != null) {
                        s1.push(a.left);
                    }
                }
            }
            res.add(r);
        }
        return res;
    }

    private ArrayList<ArrayList<Integer>> byReserve(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (pRoot == null) {
            return res;
        }
        queue.add(pRoot);
        int countRow = 1;
        while (queue.size() != 0) {
            ArrayList<Integer> r = new ArrayList<>();
            int size = queue.size();
            while (size-- != 0) {
                // 从左到右
                TreeNode tempNode = queue.remove();
                r.add(tempNode.val);
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
            if (countRow % 2 == 0) {
                reserveArr(r);
            }
            countRow++;
            res.add(r);
        }
        return res;
    }

    private void reserveArr(ArrayList<Integer> r) {
        int head = 0, last = r.size() - 1;
        // 倒置数组
        while (head < last) {
            swap(r, head, last);
            head++;
            last--;
        }
    }

    private void swap(ArrayList<Integer> r, int head, int last) {
        Integer t = r.get(head);
        r.set(head, r.get(last));
        r.set(last, t);
    }
}

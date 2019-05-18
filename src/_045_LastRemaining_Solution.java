import java.util.LinkedList;

public class _045_LastRemaining_Solution {
    public int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int cur = 0;
        int steps = m - 1;
        while (list.size() > 1) {
            // 当前开始移动到移除的位置，取模
            cur = (cur + steps) % list.size();
            list.remove(cur);
        }

        return list.size() == 1 ? list.get(0) : -1;
    }
}

import java.util.ArrayList;

public class _041_FindContinuousSequence {
    public static void main(String[] args) {
//        FindContinuousSequence(9);
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        //存放结果
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int plow = 1, phigh = 2;
        while (phigh > plow) {
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            //相等，那么就将窗口范围的所有数添加进结果集
            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = plow; i <= phigh; i++) {
                    list.add(i);
                }
                result.add(list);
                plow++;
                //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
            } else if (cur < sum) {
                phigh++;
            } else {
                //如果当前窗口内的值之和大于sum，那么左边窗口右移一下
                plow++;
            }
        }
        return result;
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> r = null;
        int max = (int) Math.sqrt(sum + 1);
        for (int i = max; i >= 2; i--) {
            double k = (sum * 1.0) / i;
            int kInt = (int) k;
            k -= kInt;
            if (i % 2 == 0 && Double.compare(k, 0.5) == 0) {
                // 这个数合法，
                int head = kInt - i / 2 + 1;
                int end = head + i;
                if (head <= 0) {
                    continue;
                }
                r = getList(head, end);
                res.add(r);
            } else if (i % 2 == 1 && Double.compare(k, 0.0) == 0) {
                // 这个数合法，
                int head = kInt - (i - 1) / 2;
                int end = head + i - 1;
                if (head <= 0) {
                    continue;
                }
                r = getList(head, end);
                res.add(r);
            }
        }
        return res;
    }

    private static ArrayList<Integer> getList(int head, int end) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (; head <= end; head++) {
            res.add(head);
        }
        return res;
    }
}

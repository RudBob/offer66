import java.util.*;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class _009_RectCover {
    Map<Integer, Integer> memo = new HashMap<>();

    public int RectCover(int target) {
        if (memo.get(target) == null) {
            if (target <= 0) {
                return 0;
            }
            if (target * 2 == 2) {
                memo.put(1,1);
            } else if (target * 2 == 4) {
                memo.put(2,2);
            } else {
                memo.put(target, RectCover((target - 1)) + RectCover(target - 2));
            }
        }
        return memo.get(target);
    }
}

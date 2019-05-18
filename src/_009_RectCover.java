import java.util.*;

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

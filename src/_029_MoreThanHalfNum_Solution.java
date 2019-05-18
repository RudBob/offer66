import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _029_MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        return byMap(array);
//        return bySort(array);

    }

    private int bySort(int[] array) {
        // 时间法：
        int len = array.length;
        // sort后直接遍历看 第[i] == [i + len/2]
        Arrays.sort(array);
        for (int i = 0; i < (len + 1) / 2; i++) {
            if (array[i] == array[i + len / 2]) {
                return array[i];
            }
        }
        return 0;
    }

    private int byMap(int[] array) {
        // 空间法：
        // HashMap 计数
        int len = array.length;
        Map<Integer, Integer> count = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            Integer a = count.get(array[i]);
            if (a != null) {
                if (a + 1 > len / 2) {
                    return array[i];
                }
                count.put(array[i], a + 1);
            } else {
                if (a + 1 > len / 2) {
                    return array[i];
                }
                count.put(array[i], 1);
            }
        }
        return 0;
    }
}

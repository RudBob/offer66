import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class _029_MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
//        return byMap(array);
//        return bySort(array);
        return byCount(array);
    }

    /**
     * 已知这个数字出现的次数比其他数字总和还要多,那么使用这个特性
     */
    private int byCount(int[] array) {
        // byCount
        if (array == null || array.length == 0) {
            return 0;
        }
        int val = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                val = array[i];
                count = 1;
            } else if (val == array[i]) {
                count++;
            } else {
                count--;
            }
        }
        // 增加一步校验
        int c = 0;
        for (int num : array) {
            if (num == val) {
                c++;
            }
        }
        return c > array.length / 2 ? val : 0;
    }

    /**
     * 通过排序,找到是否存在这个数.
     */
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

    /**
     * 使用Map计数
     */
    private int byMap(int[] array) {
        // 空间法：
        // HashMap 计数
        int len = array.length;
        Map<Integer, Integer> count = new HashMap<>(len);
        for (int num : array) {
            Integer a = count.get(num);
            a = a == null ? 0 : a;
            if (a + 1 > len / 2) {
                return num;
            }
            count.put(num, a + 1);
        }
        return 0;
    }
}

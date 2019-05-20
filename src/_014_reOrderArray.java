import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个整数数组;
 * 实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class _014_reOrderArray {
    // 重定义排序即可

    /**
     * 使用两个数组，
     * 从前遍历旧数组找到所有的奇数并放入新数组，
     * 从前遍历旧数组找到所有的奇数并放入新数组。
     * 空间O(n)，时间O(n)
     */
    public void reOrderArray(int[] array) {
//        solutionBySort(array);
        // 双数组
        // copy原数组顺序
        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        // 从前到后遍历找到所有奇数，放入结果数组中
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (copy[i] % 2 == 1) {
                array[j++] = copy[i];
            }
        }
        // 从前到后遍历找到所有偶数，放入结果数组中
        for (int i = 0; i < array.length; i++) {
            if (copy[i] % 2 == 0) {
                array[j++] = copy[i];
            }
        }
        // 上述两步可以合并为一步，但是我懒。
    }

    /**
     * 使用Java自带的比较器功能
     * 时间O(n*log(n))-->双轴排序,空间O(1)
     */
    private void solutionBySort(int[] array) {
        Integer[] a = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            a[i] = array[i];
        }
        Arrays.sort(a, new Comp());
        for (int i = 0; i < array.length; i++) {
            array[i] = a[i];
        }
    }
}

/**
 * 自定义比较器，奇数比偶数小。
 */
class Comp implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 % 2 == o2 % 2) {
            return 0;
        } else if (o1 % 2 == 0 && o2 % 2 == 1) {
            return 1;
        } else {
            return -1;
        }
    }
}

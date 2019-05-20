import java.util.*;

/**
 * 输入n个整数，找出其中最小的K个数。
 * <p>
 * 例如输入4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4,。
 */
public class _030_GetLeastNumbers_Solution {
    // 著名的Partition算法:分割,时间复杂度O(n)

    /**
     * 使用最小堆,只存储最小的k个数,时间复杂度:O(n*log(k))
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || k > input.length) {
            return res;
        }
        int[] mins = new int[k + 1];
        Arrays.fill(mins, Integer.MAX_VALUE);
        for (int i = 0; i < input.length; i++) {
            mins[k] = input[i];
            for (int j = k; j >= 1; j--) {
                if (mins[j] < mins[j - 1]) {
                    swap(mins, j, j - 1);
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < k && i < input.length; i++) {
            res.add(mins[i]);
        }
        return res;
    }

    private void swap(int[] mins, int i, int j) {
        int t = mins[i];
        mins[i] = mins[j];
        mins[j] = t;
    }

    /**
     * 每次得到最小值,(冒泡排序的思想)
     */
    private ArrayList<Integer> GetLeasetNumbersByBubbleSort(int[] input, int k) {

        ArrayList<Integer> al = new ArrayList<Integer>();
        if (k > input.length) {
            return al;
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] < input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
            al.add(input[input.length - i - 1]);
        }
        return al;
    }
}

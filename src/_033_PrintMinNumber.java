import java.util.*;

/**
 * 输入一个正整数数组，
 * 把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为3213
 */
public class _033_PrintMinNumber {
    public String PrintMinNumber(int[] numbers) {
        // 初始化各个容器
        StringBuilder s = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int num : numbers) {
            list.add(num);
        }
        // 让其排序，按照固定规则：那个数字放在前面会导致结果更小。
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        });
        // 挨个添加到结果String的尾部.
        for (int j : list) {
            s.append(j);
        }
        return s.toString();
    }
}
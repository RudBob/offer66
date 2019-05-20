import java.util.*;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class _028_Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> strs = new ArrayList<String>();
        if (str == null || str.length() == 0) {
            return strs;
        }
        char[] s = str.toCharArray();
        Arrays.sort(s);
        // 全排列,接所有可能都添加到strs中.
        Permutation(s, strs, 0);
        // 最后进行一个排序,因为递归出来的顺序中并不有序
        Collections.sort(strs);
        return strs;
    }

    /**
     * 对字符进行全排列
     */
    private void Permutation(char[] s, ArrayList<String> strs, int i) {
        if (i == s.length - 1) {
            if (!strs.contains(new String(s))) {
                strs.add(new String(s));
            }
        } else {
            for (int j = i; j < s.length; j++) {
                swap(s, i, j);
                // 递归
                Permutation(s, strs, i + 1);
                swap(s, i, j);
            }
        }
    }

    private void swap(char[] s, int i, int j) {
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
    }
}

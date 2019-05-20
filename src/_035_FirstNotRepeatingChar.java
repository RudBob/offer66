import java.util.*;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置,如果没有则返回 -1（需要区分大小写）.
 */
public class _035_FirstNotRepeatingChar {
    /**
     * 使用Map计数.
     */
    public int FirstNotRepeatingChar(String str) {
        char[] ch = str.toCharArray();
        Map<Character, Integer> countChar = new HashMap<>();
        /**
         * Map计数
         */
        for (char c : ch) {
            Integer count = countChar.get(c);
            if (count == null) {
                count = 0;
            }
            countChar.put(c, count + 1);
        }
        /**
         * 遍历，得到第一个次数为1的下标.
         */
        for (int i = 0; i < ch.length; i++) {
            if (countChar.get(ch[i]).equals(1)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 暴力搜索，O(n^2)。当然实际上效果稍微好一点.
     */
    private int byMyBooleans(String str) {
        char[] ch = str.toCharArray();
        boolean[] repeated = new boolean[ch.length];
        for (int i = 0; i < ch.length; i++) {
            if (repeated[i]) {
                continue;
            }
            int countRepeat = 0;
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[j] == ch[i]) {
                    countRepeat++;
                    repeated[j] = true;
                }
            }
            if (countRepeat == 0) {
                return i;
            }
        }
        return -1;
    }
}
/**
 * 请实现一个函数:
 * 将一个字符串中的每个空格替换成“%20”。
 * 例如
 * <p>
 * 当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 */
public class _004_replaceSpace {
    /**
     * 这道题没什么难度，但是有很多初学者喜欢使用String，这是一个大坑的。
     * String 是一个不可变的常量，"+"操作看似改变了String的值，但是原有的值依然存在。
     * 比如："Login" + "Username" --->这将在内存中出现3个String，一个"Login","Username","LoginUsername"
     * 导致了内存和时间的双重浪费.
     * <p>
     * 对于我们希望能经常改变的字符串，
     * 不考虑线程安全的话：StringBuilder；
     * 考虑线程安全的话：StringBuffer
     */
    public String replaceSpaceByStringBuilder(String str) {
        if (str == null) {
            return null;
        }
        // 转成char[]，char[]数组遍历起来会更快，即使转成char[]花费了内存和一定时间，
        // 但对于时间敏感的情况下还是可以考虑的
        char[] s = str.toCharArray();
        StringBuffer res = new StringBuffer();
        // foreach在这种情况下也是顺序的。
        for (char c : s) {
            // 遇到空格，则在res后面家伙是那个"%20",与String的 str+="%20" 操作结果一样。
            if (c == ' ') {
                res.append("%20");
            } else {
                // 非空格，直接添加至末尾即可
                res.append(c);
            }
        }
        // 将StringBuilder转为String,返回即可
        return res.toString();
    }

    /**
     * 剑指Offer中使用的是char[],这里也实现原地和原地。
     * <p>
     * 如果内存足够并且的话，使用双数组呗.
     */
    public String replaceSpaceByCharArr(String str) {
        if (str == null) {
            return null;
        }
        char[] s = str.toCharArray();
        // 申请一个适当长度的数组，在原来的数组长度上+count(' ')*2即可
        int countSpace = count(s, ' ');
        // 新数组
        char[] resArr = new char[s.length + 2 * countSpace];
        for (int i = 0, j = 0; i < s.length; i++, j++) {
            if (s[i] == ' ') {
                resArr[j++] = '%';
                resArr[j++] = '2';
                resArr[j] = '0';
            } else {
                resArr[j] = s[i];
            }
        }
        // 将Char数组转为String
        return new String(resArr);
    }

    /**
     * 计算在char数组中，target出现的次数
     */
    private int count(char[] s, char target) {
        int res = 0;
        for (char c : s) {
            if (target == c) {
                res++;
            }
        }
        return res;
    }


}

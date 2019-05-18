public class _50_match {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    public boolean matchCore(char[] str, int sIndex, char[] pt, int pIndex) {
        if (sIndex == str.length && pIndex == pt.length) {
            //有效性检验：str到尾，pattern到尾，匹配成功
            return true;
        } else if (sIndex != str.length && pIndex == pt.length) {
            //pattern先到尾，匹配失败
            return false;
        } else if (pIndex + 1 < pt.length && pt[pIndex + 1] == '*') {
            // pattern 下一位是 '*'，那么需要选择 0个，1个，若干个重复
            if ((sIndex != str.length && pt[pIndex] == str[sIndex]) || (pt[pIndex] == '.' && sIndex != str.length)) {
                return matchCore(str, sIndex, pt, pIndex + 2)
                        || matchCore(str, sIndex + 1, pt, pIndex + 2)
                        || matchCore(str, sIndex + 1, pt, pIndex);
            } else {
                // 不等于的话，直接跳过'*'
                return matchCore(str, sIndex, pt, pIndex + 2);
            }
        } else if (sIndex != str.length && (pt[pIndex] == '.' || pt[pIndex] == str[sIndex])) {
            return matchCore(str, sIndex + 1, pt, pIndex + 1);
        }
        return false;
    }
}

public class _051_isNumeric {
    public boolean isNumeric(char[] str) {
        // 'E'/'e'/'.' 都只能出现一次
        boolean e = false;
        boolean dot = false;
        int i = 0;
        // 正负号只能出现在第一位
        if (str[i] == '+' || str[i] == '-') {
            i++;
        }
        for (; i < str.length; i++) {
            // 点 前面必须有数字,后面必须有数字
            if (str[i] == '.' && !dot && i + 1 < str.length && isDigit(str[i + 1])) {
                dot = true;
            } else if ((i >= 1 && isDigit(str[i - 1])) && (str[i] == 'e' || str[i] == 'E') && !e) {
                // e前面必须是数字，后面要么是数字要么是正负号
                e = true;
                // e之后必须是整数，所以不能出现dot了。
                dot = true;
                if (i + 1 < str.length) {
                    // e 的下一位又拥有了一次 +- 号机会
                    if (str[i + 1] == '-') {
                        i++;
                    }
                } else {
                    return false;
                }
            } else if (!(str[i] <= '9' && str[i] >= '0')) {
                return false;
            }
        }
        return true;
    }

    private boolean isDigit(char c) {
        return c <= '9' && c >= '0';
    }
}

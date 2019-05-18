public class _042_ReverseSentence {
    public static void main(String[] args) {
        _042_ReverseSentence a = new _042_ReverseSentence();
        a.ReverseSentence("student. a am I");
    }

    public String ReverseSentence(String str) {
        char[] c = str.toCharArray();
        // 先反转整个字符串
        reserveStr(c, 0, c.length - 1);
        for (int last = 0, head = 0; last < c.length; last++) {
            if (c[last] == ' ') {
                reserveStr(c, head, last - 1);
                while (last < c.length && c[last] == ' ') {
                    last++;
                }
                head = last;
                last--;
            }else if(last == c.length - 1){
                reserveStr(c, head, c.length - 1);
            }
        }

        return new String(c);
    }

    private void reserveStr(char[] c, int head, int last) {
        while (head < last) {
            swap(c, head, last);
            head++;
            last--;
        }
    }

    private void swap(char[] c, int head, int last) {
        char t = c[head];
        c[head] = c[last];
        c[last] = t;
    }


}

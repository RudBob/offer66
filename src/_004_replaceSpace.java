public class _004_replaceSpace {
    public String replaceSpace(String str) {
        if(str == null){
            return null;
        }
        // 转成char[]，
        char[] s = str.toString().toCharArray();
        StringBuffer res = new StringBuffer();
        // 不可以使用forEach,因为foreach不关心顺序，但顺序对本题来说还是十分有用的。
        for (int i = 0; i < s.length; i++) {
            if(s[i] == ' '){
                res.append("%20");
            }else {
                res.append(s[i]);
            }
        }
        return res.toString();
    }
}

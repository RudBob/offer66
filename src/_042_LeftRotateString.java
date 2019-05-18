public class _042_LeftRotateString {
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0) {
            return str;
        }
        String doubleStr = str + str;
        if (n > doubleStr.length()) {
            return "";
        }
        return doubleStr.substring(n, str.length() + n);
    }
}

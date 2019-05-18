public class _047_Add {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int flag = 0;
        int i = 0;
        while(str.charAt(i) == ' '){
            i++;
        }
        if (str.charAt(i) == '+') {
            flag = 1;
            i++;
        } else if (str.charAt(i) == '-') {
            flag = -1;
            i++;
        }
        int len = str.length();
        int res = 0;
        while (i < len) {
            char a = str.charAt(i);
            if (a >= '0' && a <= '9') {
                int k = a - '0';
                res = res * 10 + k;
            } else {
                return 0;
            }
            i++;
        }
        if (flag == 0) {
            return res;
        }
        return flag * res;
    }
}

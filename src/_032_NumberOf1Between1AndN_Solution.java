public class _032_NumberOf1Between1AndN_Solution {
    public static int NumberOf1Between1AndN_Solution(int n) {
        return byBook(Integer.toString(n));
    }

    private static int byBook(String str) {
        // 判断是否合法.
        if (str == null || str.charAt(0) < '0' || str.charAt(0) > '9') {
            return 0;
        }
        // 获取第一位的数字
        int first = str.charAt(0) - '0';
        // 获取长度
        int len = str.length();
        // str.equals('0')
        if (str.equals('0')) {
            return 0;
        }
        // 如果str.equals('1'-->'9')
        if (len == 1 && first > 0) {
            return 1;
        }

        // 第一位数字为 1 的多少种可能性
        int firstDigit = 0;
        if (first > 1) {
            // 如果不是1，那么直接得到长度，比如 21345 --> 得到  10000
            firstDigit = PowerBase10(len - 1);
        } else if (first == 1) {
            firstDigit = Integer.parseInt(str.substring(1)) + 1;
        }
        // 1346-->21345除了第一位之外的数位中的数目
        // 2 * 4 * 1000     ==>  8000
        int otherDigit = first * (len - 1) * PowerBase10(len - 2);
        // 1    --->    1345
        int numRecursive = byBook(str.substring(1));
        return firstDigit + otherDigit + numRecursive;
    }

    private static int PowerBase10(int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            res *= 10;
        }
        return res;
    }

    private static int byWeb(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10)
            ones += (n / m + 8) / 10 * m + (n / m % 10 == 1 ? n % m + 1 : 0);
        return ones;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(NumberOf1Between1AndN_Solution(31256) - 10000 - 3257 - 3157 - 3127 - 3125);
    }
}

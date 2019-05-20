/**
 * 从1 到 n 中1出现的次数。
 * 例如：求出1~13的整数中1出现的次数
 * 1、10、11、12、13
 * 共6个。
 */
public class _032_NumberOf1Between1AndN_Solution {
    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(238));
    }

    public static int NumberOf1Between1AndN_Solution(int n) {
        return byWeb(n);
    }

    /**
     * 书上的写法
     */
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

    /**
     * 网上的写法
     */
    private static int byWeb(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10) {
            // 最终推导公式，我在下面进行还原.
            ones = (int) (ones + (n / m + 8) / 10 * m + (n / m % 10 == 1 ? n % m + 1 : 0));

            /**
             * 我们以 138 举例
             * 个位为1的次数有 : count(130) + count(8)--> 13 + 1
             * 十位为1的次数有 : (count(10)*10 + count(3))*1 -->
             * (不论最后一位是什么，我们只关心第二位是不是1)---> (1 + 1) * 10 --->20
             * 百位为1的次数有 ：38种，因为138的百位是1，所以答案为： 138 % 100+1
             * 所以 138 的最终结果为：  14 + 20 + 39 -->73       （我演算过了）
             */

            /**
             * 以2333为例
             * 1. -->若最后一位确定为1，则前面三位共有233种组合，此外，加上额外的2331
             * 那么计算过程如下： (2333 / 10 ) +  3 >= 1 ? 1 : 0  ---> 233 + 1 -->234
             * 10. ---> ( (233 / 10 ) + 3 >= 1 ? 1 : 0) * 10 --->(23)*10 -->240
             * 100. ---> ( (20 / 10) + 3 >= 1 ? 1 : 0) * 100 ---> 300
             * 1000. ---> ((2 / 10) + 2 >= 1 ? 1 : 0) * 1000 ---> 1000
             * 所以最后结果为： 1000+300+240+234 --> 1774       (已演算过)
             */

            /**
             * 也就是说通用公式是
             * if(第一位 < 2),那么只能计算 n % 10000（对应个数的0） + 1.
             * 比如: f(138)--》f(100) + f(38)--》f(100) + 39
             * 比如: f(238)--->f(23) +1 + f(2)*10+10 + f(0)*100+1*100 ---> 24 + 30 + 100->154
             * 特殊处理第一位和最后一位
             */
//            ones = (int) (ones + (n / m + 8) / 10 * m + (n / m % 10 == 1 ? n % m + 1 : 0));
        }
        return ones;
    }
}

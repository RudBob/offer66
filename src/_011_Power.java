/**
 * 数值的整数次方
 * <p>
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 */
public class _011_Power {
    /**
     * 直接分正负数，然后暴力累乘
     *
     * @param base     底数
     * @param exponent 幂
     */
    private double myPower(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        } else if (exponent < 0) {
            double res = base;
            while (exponent++ != -1) {
                res *= base;
            }
            return 1 / res;
        } else {
            double res = base;
            while (exponent-- != 1) {
                res *= base;
            }
            return res;
        }
    }

    // 作者推荐算法O（log(n)）

    /**
     * 进行一个推导
     * <p>
     * { a^(n/2) * a^(n/2)        // 当 n 为偶数时}
     * a^n = {                                         }
     * { a^(n/2) * a^(n/2)*n        // 当 n 为奇数时}
     * 这样时间复杂度就从O（n）降为O(log(n))
     */
    public double Power(double base, int exponent) {
        // 负数情况下,先求绝对值
        int n = Math.abs(exponent);
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return base;
        }
        //a^n = {1. a^(n/2) * a^(n/2) .             (n为偶数)
        //      {2. a^((n-1)/2) * a^((n-1)/2) * a    (n为奇数)
        // n不断除2，直到n/2 == 1 or 0
        double result = Power(base, n >> 1);

        // 求自身平方
        result = result * result;
        // 如果 幂是奇数，那么多乘一个base
        if ((n & 1) == 1) {
            result = result * base;
        }
        // 负数情况，求其倒数
        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }
}

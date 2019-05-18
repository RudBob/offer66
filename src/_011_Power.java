public class _011_Power {
    public double Power(double base, int exponent) {
        // 负数情况下的补充
        int n=Math.abs(exponent);
        // 作者推荐算法
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return base;
        }
        //a^n = {1. a^(n/2) * a^(n/2) .             (n为偶数)
        //      {2. a^((n-1)/2) * a^((n-1)/2) * a    (n为奇数)
        double result = Power(base, n >> 1);
        result *= result;
        if ((n & 1) == 1) {
            result *= base;
        }
        // 负数情况下的补充
        if(exponent < 0){
            result = 1 / result;
        }
        return result;
    }

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
}

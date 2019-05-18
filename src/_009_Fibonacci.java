/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 *
 * n<=39
 */
public class _009_Fibonacci {
    /**
     * 递推
     */
    public int Fibonacci(int n) {
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for(int i = 2; i <= n; i++){
            memo[i] = memo[i - 1] + memo[i -2];
        }
        return memo[n];
    }
    /**
     * 使用O(1)的递推
     */
    public int Fibonacci_1(int n) {
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }
        int pre = 0;
        int now = 1;
        int res = 1;
        for(int i = 2; i <= n; i++){
            res = pre + now;
            pre = now;
            now = res;
        }
        return res;
    }

    /**
     * 暴力递归(最需要优化的解法)
     */
    public int Fibonacci_Stack(int n) {
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }
        return Fibonacci_Stack(n-1) + Fibonacci_Stack(n - 2);
    }

    /**
     * 使用一个数组(或者Map也可以)优化递归
     * 这样之所以可以优化，是因为减少了重复计算：
     * 比如：
     *
     * 我们使用最左计算f(5) = f(4) + f(3) = f(3) + f(2)  + f(3)
     * --> f(2) + f(1) + f(2) + f(3)
     * --> f(1) + f(0) + f(1) + f(2) + f(3)
     * --> f(1) + f(0) + f(1) + f(1) + f(0) + f(2) + f(1)
     * --> f(1) + f(0) + f(1) + f(1) + f(0) + f(1) + f(0) + f(1)
     *  你会发现，我们计算f(2)计算了4次,f(3)计算了2次，f(4)计算了1次.
     *  如果把这些值保存起来，那么就可以了
     *
     * 使用memo计算f(4)，f(3),f(2)后存储起来，那么就变成了
     * f(5) = f(4) + f(3)
     * --> f(3) + f(2) + f(3)
     * --> [f(2) + f(1)] + f(2) + f(3)
     * --> [f(1) + f(0) + f(1)] + f(2) + f(3)
     * tip: 此时已经记忆了f(2) = [1 + 0], f(3) = [f(2) + 1]= 2
     * --> f(3) + f(2) + f(3)
     * --> 2    + 1    + 2
     * --> 5
     */
    int[] memo = new int[40];
    public int Fibonacci_Memo(int n) {

        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else {
            if(memo[n] == 0) {
                memo[n] = Fibonacci_Stack(n-1) + Fibonacci_Stack(n - 2);
            }
        }
        return memo[n];
    }

}

public class _010_NumberOf1 {
    public int NumberOf1(int n) {
        // 库函数
//         return Integer.bitCount(n);
        // 自己手写一个简单的计数器
//        return count1ByBin(n);
        // 作者推荐算法.
        // 循环次数只和二进制中的 1 的个数有关.,明显降低循环次数.
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;    // 扔掉最后一位1
        }

        return count;
    }

    private int count1ByBin(int n) {
        int count = 0;
        int flag = 1;
        // 和 int 的 字节有关，较大
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
}

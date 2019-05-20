/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */
public class _040_FindNumsAppearOnce {
    /**
     * 数字连续异或两次，就会变成 0.
     * 异或运算的特点：任何一个数字和自己做异或运算的结果都是0，任何数字和0运算的结果都是本身。
     * <p>
     * 如果题意改为：只有一个数字出现了一次，其他所有数都是两次,那么0与每一位连续异或的结果就是结果。
     * <p>
     * 那么两个不同的数，有什么区别： 最终异或的结果是a^b，也就是与两个不同的数字异或的结果
     * 找到他们的字节码的第一个为1的值，用这个值把所有数字分成两堆，一堆这一位为0，另一堆这一位为1.
     * , 把问题就转化为了上一个问题了:只有一个数字出现了一次。
     *
     * @param array
     * @param num1  ,将num1[0]
     * @param num2  ,num2[0]设置为返回结果
     */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        // 先求大家异或过一次的结果
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            // ^ ： 异或.
            res ^= array[i];
        }
        // 找到字节码里第一个不为0的值的下标
        int indexOf1 = findFirstBitIs(res);
        for (int i = 0; i < array.length; i++) {
            // 判断每个数的这一位是否为 0,以此为根据，进行分堆异或.
            if (isBit(array[i], indexOf1)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    public int findFirstBitIs(int num) {
        int indexBit = 0;
        while (((num & 1) == 0) && (indexBit) < 8 * 4) {
            num = num >> 1;
            ++indexBit;
        }
        return indexBit;
    }

    public boolean isBit(int num, int indexBit) {
        num = num >> indexBit;
        return (num & 1) == 1;
    }
}

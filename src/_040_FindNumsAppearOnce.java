public class _040_FindNumsAppearOnce {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        // 先求大家异或过一次的结果
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            // ^ ： 异或.
            res ^= array[i];
        }
        int indexOf1 = findFirstBitIs(res);
        for (int i = 0; i < array.length; i++) {
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

import java.util.*;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class _034_GetUglyNumber_Solution {
    /**
     * 找第N个丑数，那么就需要知道前N-1个丑数，也就要遍历丑数列表，
     * 但是如果直接遍历2~？，当N较大时，需要遍历的值太多，所以应该找到丑数的规律.
     * 2,3,4,5,6(2*3),9,10,12,15,18,20, 这样几乎看不到规律
     * 换种思路,2*1,3*1,2*2,5*1,2*3,2*4,3*3,2*5,
     * emmm，也就是Math.min(2*k2,3*k3,5*k5)-->选中谁，对应的ki就要自增ki++;
     */
    public int GetUglyNumber_Solution(int index) {
        // 质因数只包含 2，3，5
        // 1,2,3,5,6,8,10,12,
        if (index <= 5) {
            return index;
        }
        int[] res = new int[index];
        res[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i = 1; i < index; ++i) {
            res[i] = Math.min(res[index2] * 2, Math.min(res[index3] * 3, res[index5] * 5));
            if (res[i] == res[index2] * 2) {
                index2++;
            }
            // 不适用else if 是因为，6，10，15，30这类公倍数的原因
            if (res[i] == res[index3] * 3) {
                index3++;
            }
            if (res[i] == res[index5] * 5) {
                index5++;
            }
        }
        return res[index - 1];
    }
}

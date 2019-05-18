import java.util.*;

public class _034_GetUglyNumber_Solution {
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

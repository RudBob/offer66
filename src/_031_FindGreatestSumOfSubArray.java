/**
 * 给一个数组，返回它的最大连续子序列的和，
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 */
public class _031_FindGreatestSumOfSubArray {
    /**
     * 动态规划,使用一个sum数组,保存其向前能得到的最大值.
     * 那么 sum[i + 1] = {arr[i+1] + max(sum[i] , 0)}
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] maxSum = new int[array.length];
        maxSum[0] = array[0];
        int max = maxSum[0];
        for (int i = 1; i < array.length; i++) {
            // sum[i + 1] = {arr[i+1] + max(sum[i] , 0)}
            maxSum[i] = array[i] + Math.max(maxSum[i - 1], 0);
            // 是否改变max值
            max = maxSum[i] > max ? maxSum[i] : max;
        }
        return max;
    }
}

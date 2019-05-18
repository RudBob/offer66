public class _031_FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int[] maxSum = new int[array.length];
        maxSum[0] = array[0];
        int max = maxSum[0];
        for (int i = 1; i < array.length; i++) {
            if (maxSum[i - 1] < 0) {
                maxSum[i] = array[i];
            } else {
                maxSum[i] = maxSum[i - 1] + array[i];
            }
            if (maxSum[i] > max) {
                max = maxSum[i];
            }
        }
        return max;

        // 遍历一遍
    }
}

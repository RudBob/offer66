/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class _036_InversePairs {
    // 计数器
    int cnt;
    int[] tmp;

    /**
     * 排序后，遍历即可；O(n*log(n))
     * 当然，使用归并时，合并两个数组时，进行计数也可以(这样就省去了遍历造成的可能的O(n^2))
     */
    public int InversePairs(int[] array) {
        cnt = 0;
        if (array != null) {
            tmp = new int[array.length];
            mergeSortUp2Down(array, 0, array.length - 1);
        }
        return cnt;
    }

    /*
     * 归并排序(从上往下)
     */
    public void mergeSortUp2Down(int[] a, int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) >> 1;

        mergeSortUp2Down(a, start, mid);
        mergeSortUp2Down(a, mid + 1, end);

        merge(a, start, mid, end);
    }

    /*
     * 将一个数组中的两个相邻有序区间合并成一个
     */
    public void merge(int[] a, int start, int mid, int end) {
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (a[i] <= a[j])
                tmp[k++] = a[i++];
            else {
                tmp[k++] = a[j++];
                cnt += mid - i + 1;  // 核心代码，count值加上i举例mid+1的距离，也就是a[i-->mid+1)中的数字
                cnt %= 1000000007;
            }
        }

        while (i <= mid) {
            tmp[k++] = a[i++];
        }
        while (j <= end) {
            tmp[k++] = a[j++];
        }
        for (k = 0; k < end - start + 1; k++) {
            a[start + k] = tmp[k];
        }
    }
}

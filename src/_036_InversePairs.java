public class _036_InversePairs {

    int cnt;
    int[] tmp;

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
                cnt += mid - i + 1;  // core code, calculate InversePairs............
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

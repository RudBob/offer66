public class _048_duplicate {
    public boolean duplicate(int[] a, int length, int[] duplication) {
        for (int i = 0; i < length; i++){
            if(a[i] < 0 || a[i] > length - 1){
                return false;
            }
        }
//        return byCount(numbers, length, duplication);
        // 不适用辅助空间，有两个办法：
        // 1. swap(a[i],a[a[i]]);
        for (int i = 0; i < a.length; i++) {
            // 等于自身的下标，跳过.
            while (a[i] != i) {
                if (a[i] == a[a[i]]) {
                    // 任意重复的一个.
                    duplication[0] = a[i];
                    return true;
                }
                // 不等于时需要与 a[a[i]] 进行交换.
                swap(a, a[i], a[a[i]]);
            }
        }
        // a[a[i]] + n;
        return false;
    }

    private void swap(int[] a, int i, int i1) {
        int t = a[i];
        a[i] = a[i1];
        a[i1] = t;
    }

    private boolean byCount(int[] numbers, int length, int[] duplication) {
        for (int i = 0; i < length; i++){
            if(numbers[i] < 0 || numbers[i] > length - 1){
                return false;
            }
        }
        // 使用辅助空间
        int[] count = new int[length];
        for (int i = 0; i < length; i++) {
            if (count[numbers[i]] == 1) {
                duplication[0] = numbers[i];
                return true;
            }
            count[numbers[i]]++;
        }
        return false;
    }
}

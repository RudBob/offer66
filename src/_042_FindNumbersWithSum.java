import java.util.ArrayList;

public class _042_FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int head = 0, last = array.length - 1;
        int res0 = Integer.MAX_VALUE, res1 = Integer.MAX_VALUE;
        while (head < last) {
            int temp = array[head] + array[last];
            if (temp == sum) {
                res0 = array[head];
                res1 = array[last];
                break;
            } else if (temp < sum) {
                head++;
            } else {
                last--;
            }
        }
        ArrayList<Integer> r = new ArrayList<>();
        if (res0 != Integer.MAX_VALUE && res1 != Integer.MAX_VALUE) {
            r.add(res0);
            r.add(res1);
        }
        return r;
    }
}

import java.util.Arrays;
import java.util.Comparator;

public class _014_reOrderArray {
    // 重定义排序即可
    public void reOrderArray(int[] array) {
//        solutionBySort(array);
        // 双数组
        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (copy[i] % 2 == 1) {
                array[j++] = copy[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (copy[i] % 2 == 0) {
                array[j++] = copy[i];
            }
        }

    }

    private void solutionBySort(int[] array) {
        Integer[] a = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            a[i] = array[i];
        }
        Arrays.sort(a, new Comp());
        for (int i = 0; i < array.length; i++) {
            array[i] = a[i];
        }
    }
}

class Comp implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 % 2 == o2 % 2) {
            return 0;
        } else if (o1 % 2 == 0 && o2 % 2 == 1) {
            return 1;
        } else {
            return -1;
        }
    }
}

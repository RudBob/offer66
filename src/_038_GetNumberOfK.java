import java.util.Arrays;

public class _038_GetNumberOfK {
    public int GetNumberOfK(int[] array, int k) {
        // 使用二分查找找到第一次出现 k 的地方，和最后一次出现k的地方
        int begin = -1, end = -1;
        begin = binarySearchBegin(0, array.length - 1, array, k);
        end = binarySearchEnd(0, array.length - 1, array, k);
        if (begin == -1) {
            return 0;
        }
        return end - begin + 1;
    }

    private int binarySearchBegin(int head, int last, int[] a, int k) {
        if (head > last) {
            return -1;
        }
        if (a[head] == k) {
            return head;
        }
        int mid = (head + last) >> 1;
        if (a[mid] == k) {
            return binarySearchBegin(head, mid, a, k);
        } else if (a[mid] > k) {
            return binarySearchBegin(head, mid - 1, a, k);
        } else {
            return binarySearchBegin(mid + 1, last, a, k);
        }
    }

    private int binarySearchEnd(int head, int last, int[] a, int k) {
        if (head > last) {
            return -1;
        }
        if (a[last] == k) {
            return last;
        }
        int mid = (head + last) >> 1;
        if (a[mid] == k) {
            return binarySearchEnd(mid, last, a, k);
        } else if (a[mid] > k) {
            return binarySearchEnd(head, mid - 1, a, k);
        } else {
            return binarySearchEnd(mid + 1, last, a, k);
        }
    }

    private int byBinSearch(int[] array, int k) {
        // 二分查找出来对应的index
        int index = binarySearch(array, k);
        if (index < 0) {
            return 0;
        }
        // 得到之前与其重复的个数
        int pre = 0;
        for (int i = index; i >= 1 && array[i] == array[i - 1]; i--) {
            pre++;
        }
        int end = 0;

        for (int i = index; i < array.length - 1 && array[i] == array[i + 1]; i++) {
            end++;
        }

        return end + pre + 1;
    }

    private int binarySearch(int[] array, int k) {
        int head = 0, last = array.length - 1;
        return binarySearch(head, last, array, k);
    }

    private int binarySearch(int head, int last, int[] a, int k) {
        if (head > last) {
            return -1;
        }
        int mid = (head + last) >> 1;
        if (a[mid] == k) {
            return mid;
        } else if (a[mid] > k) {
            return binarySearch(head, mid - 1, a, k);
        } else {
            return binarySearch(mid + 1, last, a, k);
        }
    }
}

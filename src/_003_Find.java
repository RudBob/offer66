import java.util.Arrays;

public class _003_Find {

    public boolean FindByBinSearch(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        // 首先确定列，
        int x = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i][0] <= target && array[i][array[i].length - 1] >= target) {
                x = i;
                int head = 0, last = array[x].length - 1;
                while (head <= last) {
                    int mid = (head + last) / 2;
                    if (array[x][mid] == target) {
                        return true;
                    } else if (array[x][mid] > target) {
                        last = mid - 1;
                    } else {
                        head = mid + 1;
                    }
                }
            } else if (target < array[i][0]) {
                return false;
            }
        }

        return false;
    }

    public boolean Find(int target, int[][] array) {
        if(array.length == 0 || array[0].length == 0){
            return false;
        }
        // 先从矩阵的右上角开始找，这样至少可以剪掉一行或一列.
        int x = 0, y = array[0].length - 1;
        return Find(array, target, x, y);
    }

    private boolean Find(int[][] array, int target, int x, int y) {
        if(x == array.length || y == -1){
            return false;
        }
        if (array[x][y] == target) {
            return true;
        } else if (array[x][y] > target) {
            // 说明矩阵的最后一列无用
            return Find(array, target, x, y - 1);
        } else {
            // 说明矩阵剩余的第一行无用
            return Find(array, target, x + 1, y);
        }
    }
}

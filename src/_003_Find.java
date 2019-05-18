
/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * {1， 2，  3，    4，     5，
 * <p>
 * 3， 5，  7，    8，     9，
 * <p>
 * 6， 8， 11，   22，     33}
 */
public class _003_Find {
    /**
     * 常规解法：
     * 使用遍历列*二分查找列中的行.
     * 时间复杂度：O(n*log(n)),空间O(n^2)
     */
    public boolean FindByBinSearch(int target, int[][] array) {
        // 判断行于列是否都正常
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        // 遍历每一行
        for (int i = 0, x = 0; i < array.length; i++) {
            // 如果目标值落入这一行的范围内，则进行二分查找
            if (array[i][0] <= target && array[i][array[i].length - 1] >= target) {
                // 对这一行进行二分查找.
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
                // 比这一行最小值都小，那么接下来的行中也不存在目标值.
                return false;
            }
        }

        return false;
    }

    /**
     * 遍历*二分，题目中给出的两个有序，只使用了一个(另一个几乎没有使用)
     * 如何使用两个有序呢？  博客中有具体的图示 URL： https://mp.csdn.net/postedit/88371064
     * 行有序递增，列有序递增。
     * 那么对于左上角，右上角，左下角，右下角，存在这样的属性：
     * 左上：全局最小
     * 右上：所属行最大，所属列最小
     * 左下：所属列最大，所属行最小
     * 右下：全局最大.
     * 接下来以右上为例讲解：
     * <p>
     * 如果目标值大于右上角，那么这一行的值都不符合，扔掉当前行。
     * 如果目标值小于右上角，那么这一列的值都不符合，扔掉当前列。
     * 对矩阵递归进行上述步骤的切割。
     */
    public boolean Find(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        // 先从矩阵的右上角开始找，这样至少可以剪掉一行或一列.
        int x = 0, y = array[0].length - 1;
        return Find(array, target, x, y);
    }

    /**
     * @param array  查询数组.
     * @param target 目标值.
     * @param x      行的上限。
     * @param y      列的上限。
     * @return  是否查找到目标值
     */
    private boolean Find(int[][] array, int target, int x, int y) {
        if (x == array.length || y == -1) {
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

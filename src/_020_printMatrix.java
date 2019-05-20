import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * <p>
 * {------》
 * 1, 2, 3, 4, |
 * 5, 6, 7, 8, |
 * 9,10,11,12, |
 * 13,14,15,16 √
 * 《--------
 * }
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class _020_printMatrix {
    int[][] next = {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    // 我觉得本质就是一次深搜

    /**
     * 尽力向左走，走到头，向下走，走到头，向右走，向上走。
     * 绝不走走过的路.
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        // 标记是否被使用过
        boolean[][] used = new boolean[matrix.length][matrix[0].length];
        int allSize = matrix.length * matrix[0].length;
        int k = 0;
        int i = 0, j = 0;
        res.add(matrix[i][j]);
        used[i][j] = true;
        while (res.size() != allSize) {
            i += next[k][1];
            j += next[k][0];
            if (isValid(matrix, i, j) && !used[i][j]) {
                res.add(matrix[i][j]);
                used[i][j] = true;
            } else {
                i -= next[k][1];
                j -= next[k][0];
                k = (k + 1) % 4;
            }
        }
        return res;
    }

    private boolean isValid(int[][] matrix, int i, int j) {
        return i >= 0 && j >= 0 && i < matrix.length && j < matrix[0].length;
    }
}

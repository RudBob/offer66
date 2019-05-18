import java.util.ArrayList;

public class _020_printMatrix {
    int[][] next = {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    // 我觉得本质就是一次深搜
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
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

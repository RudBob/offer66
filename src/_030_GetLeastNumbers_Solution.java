import java.util.*;

public class _030_GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(input == null || k > input.length){
            return res;
        }
        int[] mins = new int[k + 1];
        Arrays.fill(mins,Integer.MAX_VALUE);
        for (int i = 0; i < input.length; i++) {
            mins[k] = input[i];
            for (int j = k; j >= 1; j--) {
                if (mins[j] < mins[j - 1]) {
                    swap(mins, j, j - 1);
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < k && i < input.length; i++) {
            res.add(mins[i]);
        }
        return res;
    }

    private void swap(int[] mins, int i, int j) {
        int t = mins[i];
        mins[i] = mins[j];
        mins[j] = t;
    }
}

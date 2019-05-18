import java.util.Arrays;

public class _044_isContinuous {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length < 5) {
            return false;
        }
        // 记录最大值最小值小于5，并且无重复值
        Arrays.sort(numbers);
        int ghost = 0;
        // countGhost;
        int i = 0;
        while (numbers[i] == 0) {
            ghost++;
            i++;
        }
        int min = numbers[i];
        for (; i < 4; i++) {
            if (numbers[i] == numbers[i + 1]) {
                return false;
            }
        }
        return numbers[4] - min < 5;
//        // 大小王是 0
//        Arrays.sort(numbers);
//        int ghost = 0;
//        // countGhost;
//        int i = 0;
//        while (numbers[i] == 0) {
//            ghost++;
//            i++;
//        }
//        for (; i < 4; i++) {
//            if (numbers[i] != numbers[i + 1] - 1 && ghost > 0) {
//                numbers[i]++;
//                ghost--;
//                i--;
//            } else if (numbers[i] != numbers[i + 1] - 1 && ghost == 0) {
//                return false;
//            }
//        }
//        return true;
    }
}

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class _022_IsPopOrder {
    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 3, 5, 1, 2};

        IsPopOrder(pushA, popA);
    }

    /**
     * 如果顺序合法，那么一定可以模拟出来.
     */
    private static boolean IsPopOrder(int[] pushA, int[] popA) {
        int pop = 0, push = 0;
        // 申请一个数组，用来模拟入栈出栈
        int[] stack = new int[pushA.length];
        int stackLen = 0;
        while (pop != popA.length) {
            if (stackLen == 0) {
                // size == 0时，只能入栈
                stack[0] = pushA[push++];
                stackLen++;
            }
            // 要出栈的是否是栈顶元素
            if (stack[stackLen - 1] == popA[pop]) {
                stackLen--;
                pop++;
            } else {
                // 如果不是，再次入栈
                try {
                    stack[stackLen++] = pushA[push++];
                } catch (Exception e) {
                    return false;
                }
            }
        }
        // 如果栈空，说明顺序合法，若有剩余，则顺序不合法
        return stackLen == 0;
    }
}

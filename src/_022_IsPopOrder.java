public class _022_IsPopOrder {
    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 3, 5, 1, 2};

        IsPopOrder(pushA, popA);
    }

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        int pop = 0, push = 0;
        int[] stack = new int[pushA.length];
        int stackLen = 0;
        while (pop != popA.length) {
            if (stackLen == 0) {
                stack[0] = pushA[push++];
                stackLen++;
            }
            if (stack[stackLen - 1] == popA[pop]) {
                stackLen--;
                pop++;
            } else {
                try {
                    stack[stackLen++] = pushA[push++];
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return stackLen == 0;
    }
}

/**
 * 输入一个整数数组，
 * 判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class _024_VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        // 如果满足最后一位数，存在某个index，
        // 之前的数都比其小，之后的数都比其大即可.
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    private boolean VerifySquenceOfBST(int[] sequence, int head, int last) {
        if(head >= last){
            return true;
        }
        int rootVal = sequence[last];
        // 遍历找左子树
        int i = head;
        int rightBeginIndex;
        for (; i < last; i++) {
            if (sequence[i] > rootVal) {
                break;
            }
        }
        rightBeginIndex = i;
        // 遍历找右子树
        // 如果右子树中存在比rootVal小的值，说明不对.
        for (; i < last; i++) {
            if (sequence[i] <= rootVal) {
                return false;
            }
        }

        return VerifySquenceOfBST(sequence, head, rightBeginIndex - 1) &&
                VerifySquenceOfBST(sequence, rightBeginIndex, head);

        // 递归进入左右子树
    }
}
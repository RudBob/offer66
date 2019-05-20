/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class _015_FindKthToTail {
    // 初学者思路
    // 1. 最简单的思路，使用数组或者队列将链表中所有数都取出来，然后再直接得到后，还原链表。
    // 但是空间代码过高，时间代价也不低

    // 正常思路
    // 2. 栈，递归法, 递归法的缺点是：如果链表过长，函数栈可能会爆掉，栈的话空间和时间复杂度都没省下.

    /**
     * 3. 相对位移法
     * 大小指针，大指针每次走两步，小指针每次走一步，
     * 那么当大指针走到头的时候，小指针正好走到一半的位置
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        // 校验输入数据
        if (head == null || k <= 0) {
            return null;
        }
        // 如果 ListNode.length() < k, 报错
        int countK = k;
        ListNode lastNode = head;
        while (countK-- != 1 && lastNode != null) {
            // 第一个指针先走 k - 1,
            lastNode = lastNode.next;
        }
        if (lastNode == null) {
            // 说明没有倒数第k个节点
            return null;
        }
        ListNode targetNode = head;
        while (lastNode.next != null) {
            // 第一个指针先走 k - 1,
            lastNode = lastNode.next;
            targetNode = targetNode.next;
        }
        return targetNode;
    }
}

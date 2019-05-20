/**
 * 输入两个单调递增的链表，
 * 输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 */
public class _017_Merge {
    // 有序链表的合并
    public ListNode Merge(ListNode list1, ListNode list2) {
        // 申请结果链表
        ListNode resHead = new ListNode(-1);
        ListNode cur = resHead;
        // 只要两个中有任意一个没有结束，就要结束循环
        while (list1 != null || list2 != null) {
            // 其中一个链表已经结束，那么直接链接就好.
            if (list1 == null) {
                cur.next = list2;
                list2 = list2.next;
            } else if (list2 == null) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                // 将较小的放入到结果链表中
                if (list1.val < list2.val) {
                    cur.next = list1;
                    list1 = list1.next;
                } else {
                    cur.next = list2;
                    list2 = list2.next;
                }
            }
            // cur后移
            cur = cur.next;
        }
        // 向后移动一位，因为这是有空头节点的链表，
        // 我们要返回没有空头节点的链表
        return resHead.next;
    }
}

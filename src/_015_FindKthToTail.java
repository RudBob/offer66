public class _015_FindKthToTail {
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

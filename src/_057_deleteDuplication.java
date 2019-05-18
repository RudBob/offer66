public class _057_deleteDuplication {
    // 链表节点的删除
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode cur = pHead;
        ListNode pre = null;
        if (pHead == null) {
            return null;
        }
        while (cur != null) {
            while (cur != null && cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
            }
            if (pre == null) {
                pre = cur;
                pHead = cur;
            } else {
                pre.next = cur;
                pre = cur;
            }
            if(cur == null){
                break;
            }
            cur = cur.next;
        }
        return pHead;
    }
}

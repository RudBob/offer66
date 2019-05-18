public class _016_ReverseList {
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            head.next.next = head;
            head.next = null;
        }
        // 三节点，mid节点的next指向pre，然后所有节点前进一位，知道lastNode.next == null;
        ListNode lastNode = head.next.next;
        ListNode midNode = head.next;
        ListNode preNode = head;
        head.next = null;
        while (lastNode != null) {
            midNode.next = preNode;
            preNode = midNode;
            midNode = lastNode;
            lastNode = lastNode.next;
        }
        // 此时mid指向最后一个node
        midNode.next = preNode;
        return midNode;
    }

    private ListNode solutionByStack(ListNode head) {
        // 一次遍历求出长度，然后使用使用一个数组存储.
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int[] stack = new int[len];
        cur = head;
        for (int i = 0; i < len; i++) {
            stack[i] = cur.val;
            cur = cur.next;
        }
        int j = len - 1;
        cur = head;
        while (cur != null) {
            cur.val = stack[j--];
            cur = cur.next;
        }
        return head;
    }
}
/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class _016_ReverseList {
    /**
     * 常规思想：使用栈的性质
     */
    private ListNode solutionByStack(ListNode head) {
        // 一次遍历求出长度，然后使用使用一个数组存储.
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int[] stack = new int[len];
        // 将数组中的值倒序放回到链表中即可。
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

    /**
     * 使用O(1)空间求解,
     * 思想：把链表中的箭头全部反向即可。
     * 这就涉及到三个指针：当前位置，下一个位置，下下一个位置.
     * 保留好各个指针，然后将next指向它的前置节点。
     */
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
        // 将next指向前一个节点。
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
        // 尾节点需要特殊处理一下。
        // 此时mid指向最后一个node
        midNode.next = preNode;
        return midNode;
    }


}
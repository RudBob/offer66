import java.util.HashSet;

public class _037_FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = (p1 == null ? pHead2 : p1.next);
            p2 = (p2 == null ? pHead1 : p2.next);
        }
        return p1;
    }

    public ListNode FindFirstCommonNodeII(ListNode pHead1, ListNode pHead2) {
        ListNode current1 = pHead1;// 链表1
        ListNode current2 = pHead2;// 链表2
        int length1 = getLength(current1);
        int length2 = getLength(current2);
        // 如果链表1的长度大于链表2的长度
        if (length1 >= length2) {
            int len = length1 - length2;
            // 先遍历链表1，遍历的长度就是两链表的长度差
            while (len > 0) {
                current1 = current1.next;
                len--;
            }
        } else if (length1 < length2) {
            // 如果链表2的长度大于链表1的长度
            int len = length2 - length1;
            // 先遍历链表1，遍历的长度就是两链表的长度差
            while (len > 0) {
                current2 = current2.next;
                len--;
            }

        }
        //开始齐头并进，直到找到第一个公共结点
        while (current1 != current2) {
            current1 = current1.next;
            current2 = current2.next;
        }
        return current1;

    }

    // 求指定链表的长度
    public static int getLength(ListNode pHead) {
        int len = 0;
        ListNode p = pHead;
        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }

    private ListNode bySet(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode head1 = pHead1;
        while (head1 != null) {
            set.add(head1);
            head1 = head1.next;
        }
        ListNode head2 = pHead2;
        while (head2 != null) {
            if (set.contains(head2)) {
                return head2;
            }
        }
        return null;
    }
}

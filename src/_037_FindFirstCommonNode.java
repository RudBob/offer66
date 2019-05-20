import java.util.HashSet;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class _037_FindFirstCommonNode {
    // 直接暴力，或者Map存储都是可行的，但一个时间复杂太高，一个对空间不太友好.

    /**
     * 循环的找，最暴力的办法，但是十分简洁。
     * 不太好理解.
     * 比如：
     * p1 ：  1->2->3->5
     * p2 ：  7->8->3->5
     * 这种，第一次就能找到1!=7,2!=8,3==3
     * 再比如：
     * p1 ：  1->2->3->5
     * p2 ：  7->3->5
     * 这种：一个是再第3个，一个是再第2个，每次循环差1个，
     * 1->2->3->5->1->2->3->5->1->2->3(第三圈)
     * 7->3->5->7->3->5->7->3->5->7->3(第四圈)
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        // 如果，两个链表没有交点，就需要一个计数器，判断是否两个链表中所有节点都相互比较过了即可.
        while (p1 != p2) {
            p1 = (p1 == null ? pHead2 : p1.next);
            p2 = (p2 == null ? pHead1 : p2.next);
        }
        return p1;
    }

    /**
     * 长度法：
     * 例1：
     * p1 ：  1->2->3->5
     * p2 ：  7->8->3->5
     * p1的长度为：4
     * p2的长度为：4
     * 4-4=0,两个指针同时从头开始走，若干步后会遇到第一个相同的节点
     * 例2：
     * p1 ：  1->2->3->5
     * p2 ：  7->3->5
     * 长度差值为：1
     * 则p1先走一步，之后p1,p2同步前进，若干步后会遇到第一个相同的节点
     */
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
        } else {
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

    /**
     * Set法
     */
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

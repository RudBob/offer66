import java.util.ArrayList;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class _005_printListFromTailToHead {
    /**
     * 使用ArrayList当作栈，
     * 当然也可以直接使用Java提供的Stack
     * 或者手动得到链表容量后使用一个数组.
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        // 从头到尾读入后翻转数组.
        while (listNode != null) {
            res.add(listNode.val);
            listNode = listNode.next;
        }
        // 反转数组
        int head = 0, last = res.size() - 1;
        while (head < last) {
            //swap(head,last)
            int temp = res.get(head);
            res.set(head, res.get(last));
            res.set(last, temp);

            head++;
            last--;
        }
        return res;
    }

    /**
     * 递归
     */
    public ArrayList<Integer> printListFromTailToHead_1(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        printListFromTailToHead(listNode, res);
        return res;
    }
    /**
     * 使用递归的方式，但是如果链表过长，那么JVM中的方法栈的容量会过大，可能导致爆掉。
     */
    //        printListFromTailToHead(listNode, res);
    private void printListFromTailToHead(ListNode listNode, ArrayList<Integer> res) {
        if (listNode.next != null) {
            printListFromTailToHead(listNode.next, res);
        }
        res.add(listNode.val);
    }
}
/**
 * class ListNode {
 * int val;
 * ListNode next = null;
 * <p>
 * ListNode(int val) {
 * this.val = val;
 * }
 * }
 */

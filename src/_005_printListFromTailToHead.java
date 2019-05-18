import java.util.ArrayList;

public class _005_printListFromTailToHead {
    // 要么用栈，要么递归.
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
            res.set(last,temp);

            head++;
            last--;
        }
        return res;
    }

    // 递归, 虽然很简洁易懂，但是可能会因为Node数目过多而爆掉.
        //        printListFromTailToHead(listNode, res);
    // 如果可以使用Java自带的栈最好，不可以也不慌，就用一个ArrayList就够
    private void printListFromTailToHead(ListNode listNode, ArrayList<Integer> res) {
        if (listNode.next != null) {
            printListFromTailToHead(listNode.next, res);
        }
        res.add(listNode.val);
    }
}


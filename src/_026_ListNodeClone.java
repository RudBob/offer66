import java.util.HashMap;

public class _026_ListNodeClone {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> copy = new HashMap<>();

        RandomListNode cHead = new RandomListNode(pHead.label);
        cHead.next = Clone(pHead.next, copy);
        RandomListNode Cter = cHead;
        RandomListNode pter = pHead;
        while (Cter != null) {
            Cter.random = copy.get(pter.random);
            Cter = Cter.next;
            pter = pter.next;
        }
        return cHead;
    }

    private RandomListNode Clone(RandomListNode pHead, HashMap<RandomListNode, RandomListNode> copy) {
        if (pHead == null) {
            return null;
        }
        RandomListNode cHead = new RandomListNode(pHead.label);
        copy.put(pHead, cHead);
        cHead.next = Clone(pHead.next, copy);
        return cHead;
    }
}

import java.util.HashSet;

public class _054_EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        HashSet<ListNode> set = new HashSet<>();
        while (pHead != null) {
            if(set.contains(pHead)){
                return pHead;
            }
            set.add(pHead);
            pHead = pHead.next;
        }
        return null;
    }
}

public class _017_Merge {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode res = head;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                res.next = list2;
                list2 = list2.next;
            }else if(list2 == null){
                res.next = list1;
                list1 = list1.next;
            }else{
                if(list1.val < list2.val){
                    res.next = list1;
                    list1 = list1.next;
                }else{
                    res.next = list2;
                    list2 = list2.next;
                }
            }
            res = res.next;
        }
        return head.next;
    }
}

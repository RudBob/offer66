import java.util.HashMap;

/**
 * 输入一个复杂链表
 * （每个节点中有节点值，
 * 以及两个指针，
 * 一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 */
public class _026_ListNodeClone {
    /**
     * 最简单最暴力的办法就是将所有链表节点用Map保存起来，等到新节点时取出
     */
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

    /**
     * 克隆节点， 并将节点放入Map中
     */
    private RandomListNode Clone(RandomListNode pHead, HashMap<RandomListNode, RandomListNode> copy) {
        if (pHead == null) {
            return null;
        }
        RandomListNode cHead = new RandomListNode(pHead.label);
        copy.put(pHead, cHead);
        cHead.next = Clone(pHead.next, copy);
        return cHead;
    }

    /**
     * 将自身节点copy一份插入到自己的next处
     * 遍历所有旧节点，把其random指针的next赋给新节点的random
     * 将新旧节点分离即可。
     */
    public RandomListNode CloneByDoubleNode(RandomListNode pHead) {
        // 将自身copy一份插入到自己的next处.
        copySelfToNext(pHead);
        // 将旧random的next赋给新节点的random
        setNewRandom(pHead);

        // 新节点，从原链表中分离
        RandomListNode newHead = divideNewNode(pHead);

        return newHead;
    }

    private RandomListNode divideNewNode(RandomListNode pHead) {
        RandomListNode newHead = new RandomListNode(-1);
        RandomListNode cur = newHead;
        while (pHead != null) {
            // 将copy节点移除
            RandomListNode copy = pHead.next;
            pHead.next = copy.next;
            pHead = pHead.next;
            // 并添加到newHead链表中
            cur.next = copy;
            cur = cur.next;
        }
        cur.next = null;
        return newHead.next;
    }

    private void setNewRandom(RandomListNode pHead) {
        while (pHead != null) {
            // 就是把旧节点的random的copy节点赋给新节点的random
            // 不一定有random
            if (pHead.random != null) {
                pHead.next.random = pHead.random.next;
            }
            pHead = pHead.next.next;
        }
    }

    private void copySelfToNext(RandomListNode pHead) {
        while (pHead != null) {
            // copy节点
            RandomListNode copyNode = new RandomListNode(pHead.label);
            // 插入next上
            copyNode.next = pHead.next;
            pHead.next = copyNode;
            // pHead后移
            pHead = copyNode.next;
        }
    }
}

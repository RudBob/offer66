import java.util.Stack;

/**
 * 包含min函数的栈
 * 定义栈的数据结构，
 * 请在该类型中实现一个能够得到栈中所含最小元素的min函数
 * (时间复杂度应为O(1))。
 */
public class _021_StackWithMin {
    // 定义两个栈，一个当作正常栈，另一个专门为了实现min()即可
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    /**
     * 需要注意的是：对于minStack来说，
     * 只要保证它能在任何情况下都是最小即可，其余的值不必存储。
     * 比如主栈存： 5,7,3,9,1
     * 那么最小栈为:5,5,3,3,1   即可.
     * 但是为了pop()更方便：
     * main:5，7，3，9，1
     * min ：1,1,1,1,1
     * 过程如下：
     * 1.
     * main : 5
     * min : 5
     * 2.
     * main: 5,7
     * min: 5,5
     * 3.
     * main: 5,7,3
     * min : 5,5,3
     * 4.
     * main: 5,7,3,9
     * min : 5,5,3,3
     * 5.
     * main: 5,7,3,9,1
     * min : 5,5,3,3,1
     * 如果pop一下：
     * main: 5,7,3,9
     * min:  5,5,3,3
     */
    public void push(int node) {
        if (minStack.size() == 0) {
            minStack.push(node);
        } else {
            // 如果存值比栈顶小，那么
            if (minStack.peek() > node) {
                minStack.push(node);
            } else {
                // 如果待存值比栈顶大，那么复制一份栈顶存入
                minStack.push(minStack.peek());
            }
        }
        mainStack.push(node);
    }

    public void pop() {
        if (mainStack.size() > 0) {
            mainStack.pop();
            minStack.pop();
        } else {
            // 抛出异常
        }
    }

    public int top() {
        return mainStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}

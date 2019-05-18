import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。
 * 队列中的元素为int类型。
 */
public class _007_QueueByTwoStack {
    // 两个方向相反的栈，先在in栈堆积，然后统一到out栈输出，保证有序。
    Stack<Integer> out = new Stack<>();
    Stack<Integer> in = new Stack<>();

    // 进入in栈
    public void push(int node) {
        in.add(node);
    }

    /**
     * 先从out栈取，如果out栈为空，那么将in栈的值全部push到out栈，然后取值。
     */
    public int pop() {
        // 当正序弹出的栈中没有值的时候，从逆序栈中取出所有元素.
        if(out.size() == 0){
            while (in.size() != 0){
                out.add(in.pop());
            }
        }
        // if (head.size() == 0) throw Exception
        return out.pop();
    }
}

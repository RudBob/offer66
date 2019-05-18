import java.util.Stack;

public class _007_QueueByTwoStack {
    Stack<Integer> head = new Stack<Integer>();
    Stack<Integer> last = new Stack<Integer>();

    public void push(int node) {
        last.add(node);
    }

    public int pop() {
        // 当正序弹出的栈中没有值的时候，从逆序栈中取出所有元素.
        if(head.size() == 0){
            while (last.size() != 0){
                head.add(last.pop());
            }
        }
        // if (head.size() == 0) throw Exception
        return head.pop();
    }
}

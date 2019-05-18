import java.util.Stack;

public class _021_StackWithMin {
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        if(minStack.size() == 0){
            minStack.push(node);
        }else {
            if(minStack.peek() > node){
                minStack.push(node);
            }else {
                minStack.push(minStack.peek());
            }
        }
        mainStack.push(node);
    }

    public void pop() {
        if(mainStack.size() > 0){
            mainStack.pop();
            minStack.pop();
        }else {
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

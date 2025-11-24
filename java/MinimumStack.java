import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
// https://neetcode.io/problems/minimum-stack?list=neetcode150
class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();

    }

    public void push(int val) {
        this.stack.push(val);

        if (this.minStack.isEmpty() || val <= this.minStack.peek()) {
            this.minStack.push(val);
        }
    }

    public void pop() {
        if (this.stack.isEmpty()) {
            return;
        }

        int topValue = this.stack.pop();
        if (topValue == this.minStack.peek()) {
            this.minStack.pop();
        }
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return this.minStack.peek();
    }
}

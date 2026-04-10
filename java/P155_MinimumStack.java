import java.util.ArrayDeque;

// https://neetcode.io/problems/minimum-stack?list=neetcode150
class P155_MinimumStack {

    private ArrayDeque<Integer> stack;
    private ArrayDeque<Integer> minStack;

    public P155_MinimumStack() {
        this.stack = new ArrayDeque<Integer>();
        this.minStack = new ArrayDeque<Integer>();

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

    public static void main(String[] args) {
        P155_MinimumStack sol = new P155_MinimumStack();
        sol.push(-2);
        sol.push(0);
        sol.push(-3);
        System.out.println(sol.getMin()); // -3
        sol.pop();
        System.out.println(sol.top()); // 0
        System.out.println(sol.getMin()); // -2
    }
}

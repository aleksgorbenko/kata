
// ArrayList, HashMap, HashSet, Queue, PriorityQueue, etc.
import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/online-stock-span/description/
class StockSpanner {
    private Deque<int[]> stack;

    public StockSpanner() {
        this.stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;
        // calculate span using stack
        while (!stack.isEmpty() && price >= stack.peek()[0]) {
            span += stack.pop()[1];
        }

        // push new span with the current price
        stack.push(new int[] { price, span });

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
import java.util.ArrayDeque;
import java.util.Queue;

// https://leetcode.com/problems/number-of-recent-calls/description/
class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
        this.queue = new ArrayDeque<Integer>();
    }

    public int ping(int t) {
        // remove all items that are older than 3000ms
        // t = 10000, 10000 - t > 3000 which has be larger than
        while (!this.queue.isEmpty() && t - this.queue.peek() > 3000) {
            queue.poll();
        }

        queue.offer(t); // enque new item
        return queue.size(); // return size of queue only containing < 3000ms
    }
}
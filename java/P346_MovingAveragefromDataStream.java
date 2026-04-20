import java.util.ArrayDeque;
import java.util.Queue;

// https://leetcode.com/problems/moving-average-from-data-stream/description/
class MovingAverage {
    private Queue<Integer> queue;
    private int windowSize;
    private int windowSum;

    public MovingAverage(int size) {
        this.queue = new ArrayDeque<>();
        this.windowSize = size;
        this.windowSum = 0;
    }

    public double next(int val) {
        // if this is first item, just return itself
        if (this.queue.size() == 0) {
            this.queue.offer(val);
            this.windowSum += val;

            return val / 1.0;
        }

        if (this.queue.size() == this.windowSize) {
            // add new item
            this.queue.offer(val);
            this.windowSum += val;
            // remove last item and subtract it
            this.windowSum -= this.queue.poll();

            return (double) this.windowSum / this.windowSize;
        }

        // add item, we will only get here while
        // queue size is < 3
        this.windowSum += val;
        this.queue.offer(val);

        return (double) this.windowSum / this.queue.size();

    }
}
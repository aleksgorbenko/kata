// https://leetcode.com/problems/number-of-recent-calls/description/

package main

type RecentCounter struct {
	queue []int
}

func Constructor() RecentCounter {
	return RecentCounter{}
}

func (this *RecentCounter) Ping(t int) int {
	for len(this.queue) > 0 && (t-this.queue[0] > 3000) {
		// keep removing items from the front, as we append towards end
		this.queue = this.queue[1:]
	}

	// since we use slice, we insert at the end
	this.queue = append(this.queue, t)
	return len(this.queue)
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Ping(t);
 */

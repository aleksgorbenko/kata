// https://leetcode.com/problems/implement-queue-using-stacks/description/

package main

type MyQueue struct {
	q []int
}

func Constructor() MyQueue {
	return MyQueue{}
}

func (this *MyQueue) Push(x int) {
	this.q = append(this.q, x)
}

func (this *MyQueue) Pop() int {
	if !this.Empty() {
		x := this.q[0]
		this.q = this.q[1:len(this.q)]
		return x
	}

	return 0
}

func (this *MyQueue) Peek() int {
	if !this.Empty() {
		return this.q[0]
	}

	return 0
}

func (this *MyQueue) Empty() bool {
	return len(this.q) == 0
}

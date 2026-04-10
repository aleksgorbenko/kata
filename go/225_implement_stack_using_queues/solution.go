// https://leetcode.com/problems/implement-stack-using-queues/description/

package main

type MyStack struct {
	items []int
}

func Constructor() MyStack {
	return MyStack{
		items: []int{},
	}
}

func (this *MyStack) Push(x int) {
	this.items = append(this.items, x)
}

func (this *MyStack) Pop() int {
	if this.Empty() {
		return 0
	}

	x := this.items[len(this.items)-1]
	this.items = this.items[:len(this.items)-1]

	return x
}

func (this *MyStack) Top() int {
	if this.Empty() {
		return 0
	}
	return this.items[len(this.items)-1]
}

func (this *MyStack) Empty() bool {
	return len(this.items) == 0
}

/**
 * Your MyStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * param_2 := obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.Empty();
 */

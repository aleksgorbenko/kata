// https://leetcode.com/problems/swap-nodes-in-pairs/description/

package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func swapPairs(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	// alwasy a dummy
	dummy := &ListNode{Next: head}
	// newHead := dummy.Next.Next
	prev := dummy

	for prev.Next != nil && prev.Next.Next != nil {
		// get two nodes
		first := prev.Next
		second := first.Next

		// swap nodes
		prev.Next = second
		first.Next = second.Next
		second.Next = first

		// move to the next pair
		prev = first
	}

	return dummy.Next
}

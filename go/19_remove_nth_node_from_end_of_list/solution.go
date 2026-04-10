// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	dummy := &ListNode{Next: head}

	slow := dummy
	fast := dummy

	// move fast to n+1 steps
	for i := 0; i <= n; i++ {
		fast = fast.Next
	}

	// move to the end of list
	for fast != nil {
		slow = slow.Next
		fast = fast.Next
	}

	// reassign to a node skipping the one that we are currently on
	slow.Next = slow.Next.Next

	// return initial head
	return dummy.Next
}

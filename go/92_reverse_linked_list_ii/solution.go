// https://leetcode.com/problems/reverse-linked-list-ii/description/

package main

import (
	"fmt"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

func listToString(head *ListNode) string {
	result := ""
	for head != nil {
		if result != "" {
			result += " -> "
		}
		result += fmt.Sprintf("%d", head.Val)
		head = head.Next
	}
	return result
}

func reverseBetween(head *ListNode, left int, right int) *ListNode {
	// handle empty list that does not need to be reversed
	if head == nil || left == right {
		return head
	}

	// 1. dummy node
	// The dummy node handles the edge case where left == 1
	// meaning you need to reverse starting from the very first node.
	// Without dummy, prevLeft needs to point to the node before the reversal starts.
	// But if left == 1, there is no node before head — so prevLeft would be nil
	// and your reversal logic would crash on prevLeft.Next.
	dummy := &ListNode{Val: 0, Next: head}
	prevLeft := dummy
	// 2. move to position just before left index
	for i := 0; i < left-1; i++ {
		prevLeft = prevLeft.Next
	}

	nodeToReverse := prevLeft.Next // the first node to reverse will be next after left position
	for i := 0; i < right-left; i++ {
		next := nodeToReverse.Next

		nodeToReverse.Next = next.Next
		next.Next = prevLeft.Next
		prevLeft.Next = next
	}

	return dummy.Next
}

func main() {
	head := &ListNode{1, &ListNode{2, &ListNode{3, &ListNode{4, &ListNode{5, nil}}}}}
	fmt.Println(listToString(reverseBetween(head, 2, 4))) // 1 -> 4 -> 3 -> 2 -> 5
}

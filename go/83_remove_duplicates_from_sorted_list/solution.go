// https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/

package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func deleteDuplicates(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	// store the pointer to head
	dummy := &ListNode{Next: head}

	for head != nil && head.Next != nil {
		// compare current and next
		// if same - reconnect to next.next
		if head.Val == head.Next.Val {
			head.Next = head.Next.Next
		} else {
			head = head.Next
		}
	}

	// return head that we saved at the start
	return dummy.Next
}

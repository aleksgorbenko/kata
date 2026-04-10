// https://leetcode.com/problems/add-two-numbers/description/

package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil && l2 == nil {
		return nil
	}

	if l1 == nil && l2 != nil {
		return l2
	} else if l2 == nil && l1 != nil {
		return l1
	}

	dummy := &ListNode{}
	prev := dummy
	carry := false
	l1Next := l1
	l2Next := l2

	// loop until BOTH are nil
	for l1Next != nil || l2Next != nil {
		// if either is nil, just set them to 0 value
		if l1Next == nil {
			l1Next = &ListNode{}
		} else if l2Next == nil {
			l2Next = &ListNode{}
		}

		// compute new value
		val := l1Next.Val + l2Next.Val
		// if carry from previous run we need to +1
		if carry {
			val++
			// reset carry for next iteration
			carry = false
		}

		// if val is 10 val will be 0, if > 10, it will be modulo
		if val >= 10 {
			carry = true
			val = val % 10
		}

		// create a new node
		// and move to the next node
		newNode := &ListNode{Val: val}
		prev.Next = newNode
		prev = newNode

		// move to the next
		l1Next = l1Next.Next
		l2Next = l2Next.Next
	}

	// handle if carry is true for last iteration
	if carry {
		prev.Next = &ListNode{Val: 1}
	}

	return dummy.Next
}

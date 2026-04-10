// https://leetcode.com/problems/reverse-linked-list/description/

package main

import "fmt"

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

func reverseList(head *ListNode) *ListNode {
	if head == nil {
		return head
	}

	var prev *ListNode
	// start with head
	current := head
	for {
		// 1. save next node for later re-assignment
		next := current.Next
		// 2. current node (head on 1st iteration) points to nil now
		current.Next = prev
		// 3. re-assign previous to the current node
		prev = current
		// 4. re-assign current to the next node we saved in step 1
		current = next

		if next == nil {
			break
		}
	}

	// this is the new head of reversed linked list
	return prev
}

func main() {
	head := &ListNode{1, &ListNode{2, &ListNode{3, &ListNode{4, &ListNode{5, nil}}}}}
	fmt.Println(listToString(reverseList(head))) // 5 -> 4 -> 3 -> 2 -> 1
}

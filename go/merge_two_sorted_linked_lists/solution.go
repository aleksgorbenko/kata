// https://neetcode.io/problems/merge-two-sorted-linked-lists/question

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

func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
	if list1 == nil && list2 == nil {
		return nil
	}

	if list1 == nil && list2 != nil {
		return list2
	}

	if list1 != nil && list2 == nil {
		return list1
	}

	dummy := &ListNode{}
	node := dummy

	// if one list is nil, we exit the loop
	for list1 != nil && list2 != nil {
		if list1.Val < list2.Val {
			node.Next = list1
			list1 = list1.Next
		} else {
			node.Next = list2
			list2 = list2.Next
		}
		// re-assign current node
		node = node.Next
	}

	// on of them can be nil and have X items, we simply
	// attach the rest as we know lists are sorted
	if list1 != nil {
		node.Next = list1
	} else {
		node.Next = list2
	}

	return dummy.Next
}

func main() {
	list1 := &ListNode{1, &ListNode{2, &ListNode{4, nil}}}
	list2 := &ListNode{1, &ListNode{3, &ListNode{4, nil}}}
	fmt.Println(listToString(mergeTwoLists(list1, list2))) // 1 -> 1 -> 2 -> 3 -> 4 -> 4
}

// https://neetcode.io/problems/reverse-a-linked-list?list=neetcode150

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func reverseList(head *ListNode) *ListNode {
    if head == nil {
        return nil
    }
    
    curr := head
    var prev *ListNode
    for curr != nil {
        // ref the next node
        next := curr.Next
        // set the current node (head at the start) to prev value
        curr.Next = prev
        // prev now needs to become current node
        prev = curr
        // current node needs to become next
        curr = next
    }

    return prev
}

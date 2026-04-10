// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
class P19_RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        // move fast pointer to n+1 steps
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // move both pointers until fast hits the end
        // this will put slow into position
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // re-assign the element
        slow.next = slow.next.next;

        // return the original head
        return dummy.next;
    }
}
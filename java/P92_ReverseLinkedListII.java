// https://leetcode.com/problems/reverse-linked-list-ii/description/
class P92_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        var dummy = new ListNode();
        dummy.next = head;

        var prev = dummy;
        // move to starting point
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        var curr = prev.next;
        for (int i = 0; i < right - left; i++) {
            var then = curr.next;

            curr.next = then.next;
            then.next = prev.next;
            prev.next = then;
        }

        return dummy.next;
    }
}
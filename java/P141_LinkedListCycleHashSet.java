import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/linked-list-cycle/description/
class P141_LinkedListCycleHashSet {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Set<ListNode> seen = new HashSet<>();

        while (head != null && head.next != null) {
            if (seen.contains(head)) {
                return true;
            }
            seen.add(head);
            head = head.next;
        }

        return false;
    }
}
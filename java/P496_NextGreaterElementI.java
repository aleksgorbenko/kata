import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

// https://leetcode.com/problems/next-greater-element-i/description/
class P496_NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        var n = nums1.length;
        var ans = new int[n];

        HashMap<Integer, Integer> indexOfNextGreaterElement = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums2.length; i++) {
            var curr = nums2[i];
            while (!stack.isEmpty() && curr > stack.peek()) {
                indexOfNextGreaterElement.put(stack.pop(), curr);
            }

            // store the element in stack
            stack.push(nums2[i]);
        }

        for (int i = 0; i < n; i++) {
            if (indexOfNextGreaterElement.containsKey(nums1[i])) {
                ans[i] = indexOfNextGreaterElement.get(nums1[i]);
            } else {
                ans[i] = -1;
            }
        }

        return ans;
    }
}
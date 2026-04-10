
// Arrays.sort(), Arrays.fill(), Arrays.asList()
// Collections.sort(), Collections.reverseOrder()
import java.util.*; // ArrayList, HashMap, HashSet, Queue, PriorityQueue, etc.

// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

class P104_MaximumDepthofBinaryTreeNoRecursion {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // keep track of all nodes we visit
        Deque<TreeNodeDepthPair> stack = new ArrayDeque<>();
        // push our node as the first node to start traversal
        TreeNodeDepthPair node = new TreeNodeDepthPair(root, 1);
        stack.push(node);
        int answer = 0;

        while (!stack.isEmpty()) {
            // take the first item from stack
            TreeNodeDepthPair item = stack.pop();

            if (item.node.left != null) {
                stack.push(new TreeNodeDepthPair(item.node.left, item.depth + 1));
            }

            if (item.node.right != null) {
                stack.push(new TreeNodeDepthPair(item.node.right, item.depth + 1));
            }

            answer = Math.max(answer, item.depth);
        }

        return answer;
    }
}
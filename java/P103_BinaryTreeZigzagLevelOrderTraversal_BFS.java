
// ArrayList, HashMap, HashSet, Queue, PriorityQueue, etc.
import java.util.ArrayList;
import java.util.Collections; // Collections.sort(), Collections.reverseOrder()
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
class P103_BinaryTreeZigzagLevelOrderTraversal_BFS {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        // we need to control direction
        var leftToRightDirection = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> vals = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                // if we control direction correctly
                // we should be able to just save value in the order
                // we read them
                var node = queue.poll();
                vals.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // just reverse before saving
            // every time it is right to left
            if (!leftToRightDirection) {
                Collections.reverse(vals);
            }
            ans.add(vals);
            // flip direction to add new nodes in separate
            // direction
            leftToRightDirection = !leftToRightDirection;
        }

        return ans;
    }
}
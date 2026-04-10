
// ArrayList, HashMap, HashSet, Queue, PriorityQueue, etc.
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
class P103_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // we need to control direction
        var leftToRightDirection = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> vals = new ArrayList<>();
            Deque<TreeNode> deq = new ArrayDeque<>();
            for (int i = 0; i < levelSize; i++) {
                // if we control direction correctly
                // we should be able to just save value in the order
                // we read them
                var node = queue.remove();
                vals.add(node.val);
                if (leftToRightDirection == true) {
                    if (node.left != null) {
                        deq.push(node.left);
                    }
                    if (node.right != null) {
                        deq.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        deq.push(node.right);
                    }
                    if (node.left != null) {
                        deq.push(node.left);
                    }
                }
            }
            while (deq.size() > 0) {
                queue.add(deq.pop());
            }
            ans.add(vals);
            // flip direction to add new nodes in separate
            // direction
            leftToRightDirection = !leftToRightDirection;
        }

        return ans;
    }
}
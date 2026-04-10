
// ArrayList, HashMap, HashSet, Queue, PriorityQueue, etc.
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/deepest-leaves-sum/description/
class P1302_DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        int ans = 0;
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
            var lastSum = 0;
            var levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                var node = queue.remove();

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                // this is leaf node, we add to sum
                if (node.left == null && node.right == null) {
                    lastSum += node.val;
                }
            }
            ans = lastSum;
        }

        return ans;
    }
}
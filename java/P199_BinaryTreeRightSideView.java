
// ArrayList, HashMap, HashSet, Queue, PriorityQueue, etc.
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-right-side-view/description/

class P199_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            var currentLevelNodes = queue.size();
            for (int i = 0; i < currentLevelNodes; i++) {
                // 1: 1
                // 2: 2

                // we need to get the rightmost node on every level
                // if there is only one node on level - it will be visible,
                // OR if we are at the right-most node - it is also visible
                var currNode = queue.remove();
                if (currentLevelNodes == 1 || i + 1 == currentLevelNodes) {
                    ans.add(currNode.val);
                }

                // add left node to scan next
                if (currNode.left != null) {
                    // 1: add 2
                    queue.add(currNode.left);
                }
                // add right node to scan next
                if (currNode.right != null) {
                    // 1: add 3
                    queue.add(currNode.right);
                }
            }
        }

        return ans;
    }
}
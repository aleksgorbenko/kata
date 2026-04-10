// https://leetcode.com/problems/minimum-depth-of-binary-tree/description/

class P111_MinimumDepthofBinaryTreeRecursion {
    public int minDepth(TreeNode root) {
        // base case - we reached bottom
        if (root == null) {
            return 0;
        }

        // base case - leaf node, count as 1
        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        // handles when left node was leaf
        // we hit the "root == null" check
        // we return whatever is the right + current node
        if (left == 0) {
            return right + 1;
        }

        // handles when right node was leaf
        // we hit the "root == null" check
        if (right == 0) {
            return left + 1;
        }

        // we need +1 to count the current node
        // since we don't track the number with a variable

        // every time we go UP the stack, AND left/right are BOTH > 0,
        // we track minimum here +1 for current node
        return Math.min(left, right) + 1;
    }
}
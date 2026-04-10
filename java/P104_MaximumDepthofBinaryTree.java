// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

class P104_MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }
        // get left max depth
        int maxLeft = maxDepth(root.left);
        // get right max depth
        int maxRight = maxDepth(root.right);

        // root counts as 1, so we need add 1 to maximum
        return Math.max(maxLeft + 1, maxRight + 1);
    }
}
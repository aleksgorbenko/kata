// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

class P124_BinaryTreeMaximumPathSumRecursion {
    // tracking variable
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // 1. parse tree
        dfs(root);
        // 2. return tracking variable
        return max;
    }

    public int dfs(TreeNode root) {
        // 1. base case - we reached the end
        // we return: value of node?
        if (root == null) {
            return 0;
        }

        // 2. send scouts
        // return largest sum of the subtree?
        // IGNORE THE SUBTREE WITH NEGATIVE SUM
        // set it to ZERO as default
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);

        // 3. combine left and right sums AND CURRENT NODE and
        // compare with max
        max = Math.max(max, left + right + root.val);

        // 4. return value of the node and
        // LARGEST SUBTREE SUM
        return Math.max(left, right) + root.val;
    }
}
// https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/

class P530_MinimumAbsoluteDifferenceinBST {
    private int min = Integer.MAX_VALUE;
    private TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return this.min;
    }

    public void dfs(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }

        // items are sorted IN ORDER left < node < right
        // BST -> IN ORDER Processing
        // 1. process left
        // we may go the very bottom here and find the value that will
        // compared in step 2
        if (root.left != null) {
            dfs(root.left);
        }

        // 2. process node itself
        if (this.prev != null) {
            this.min = Math.min(min, root.val - prev.val);
        }

        // this is KEY - track previous node value
        this.prev = root;

        // 3. process right
        if (root.right != null) {
            dfs(root.right);
        }
    }
}
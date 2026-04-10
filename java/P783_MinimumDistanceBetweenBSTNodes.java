// https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/

class P783_MinimumDistanceBetweenBSTNodes {
    private int min = Integer.MAX_VALUE;
    private TreeNode prev = null;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return this.min;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        // MUST PROCESS IN ORDER
        dfs(root.left);
        if (this.prev != null) {
            this.min = Math.min(this.min, root.val - prev.val);
        }

        this.prev = root;

        dfs(root.right);
    }
}
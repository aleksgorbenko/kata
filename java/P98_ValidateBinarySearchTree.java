// https://leetcode.com/problems/validate-binary-search-tree/description/
class P98_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        // 1. we need to traverse WHOLE tree, so O(n) to confirm TRUE
        // 2. we need compare each child with MIN and MAX range
        // which will narrow down with every level

        // base case - null root
        if (root == null) {
            return false;
        }
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, long min, long max) {
        // reached end - no issues so far, return true
        if (root == null) {
            return true;
        }

        // confirm current node is in range
        if (root.val >= max || root.val <= min) {
            return false;
        }

        // LEFT must be between MIN and current node
        boolean left = dfs(root.left, min, root.val);

        // RIGHT must be between current node and max
        boolean right = dfs(root.right, root.val, max);

        return left && right;
    }
}
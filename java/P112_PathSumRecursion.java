// https://leetcode.com/problems/path-sum/description/

class P112_PathSumRecursion {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // base case for when we didn't find anything
        if (root == null) {
            return false;
        }

        // base case for when we are at leaf nodes
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        var hasLeft = hasPathSum(root.left, targetSum - root.val);
        var hasRight = hasPathSum(root.right, targetSum - root.val);

        return hasLeft || hasRight;
    }
}
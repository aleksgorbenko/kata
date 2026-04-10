// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/

class P1026_MaximumDifferenceBetweenNodeandAncestorRecursion {
    public int maxAncestorDiff(TreeNode root) {
        // we need to find the largest number in left and right sides
        // subtract the smallest number down the in the tree
        // return maximum value (all node values are positive)

        // we probably need a separate function?
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int dfs(TreeNode root, int maxValue, int minValue) {
        // base case - return no diff
        // if we reached end of tree, we can subctract
        // max and min
        if (root == null) {
            return maxValue - minValue;
        }

        // track max value
        if (root.val > maxValue) {
            maxValue = root.val;
        }
        // track min value
        if (root.val < minValue) {
            minValue = root.val;
        }

        int left = dfs(root.left, maxValue, minValue);
        int right = dfs(root.right, maxValue, minValue);

        return Math.max(right, left);
    }
}
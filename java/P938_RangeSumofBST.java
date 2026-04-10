// https://leetcode.com/problems/range-sum-of-bst/description/
class P938_RangeSumofBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        // base case - reached the end
        // return node value - 0
        if (root == null) {
            return 0;
        }

        // if current node is less than low
        // everything below it will be less than low
        // ignore left subtree, only go for right subtree
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        // same but opposite
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        // send out scouts
        int left = rangeSumBST(root.left, low, high);
        int right = rangeSumBST(root.right, low, high);
        int sum = left + right;
        if (root.val <= high && root.val >= low) {
            sum += root.val;
        }

        // return current sum of the two subtrees
        // and current node if within range
        return sum;
    }
}
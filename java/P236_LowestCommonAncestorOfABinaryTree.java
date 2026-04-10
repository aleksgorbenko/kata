// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
/**
 * Definition for a binary tree node.
 */

class P236_LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case - got to the bottom and found nothing
        if (root == null) {
            return null;
        }

        // Rule 1: found one of them
        // base case - found one or the other
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // Rule 2: one on each side, I'm the answer
        // if we found both - return current node
        if (left != null && right != null) {
            return root;
        }

        // Rule 3: pass up the call stack to a higher Node
        // Scenario A: when lowestCommonAncestor returns, IF there is an LCA, then
        // eventually we will end up hitting Rule 2 above and returning the answer

        // Scenario B: The LCA was already found below.
        // One of the recursive calls already returned the answer via Rule 2
        // and you're just passing it up. You won't hit Rule 2 again — you're just
        // relaying the answer.
        return left != null ? left : right;
    }
}
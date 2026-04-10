// https://leetcode.com/problems/same-tree/description/

class P100_SameTreeRecursion {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base case - we reached the bottom leaves
        if (p == null && q == null) {
            return true;
        }

        // base case when trees have different depth
        if ((p == null && q != null) || (q == null && p != null)) {
            return false;
        }

        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
}
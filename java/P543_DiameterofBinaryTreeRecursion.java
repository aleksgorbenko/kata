// https://leetcode.com/problems/diameter-of-binary-tree/description/
class P543_DiameterofBinaryTreeRecursion {
    // 0. track diameter in a member variable!
    private int dia = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        // parse the tree
        dfs(root, this.dia);
        // return the updated value
        return this.dia;
    }

    public int dfs(TreeNode root, int dia) {
        // 1. base case - leaf node
        // return number of edges to get here
        if (root == null) {
            return 0;
        }

        // 2. combine - count - EDGES in all left and right children
        // compare with dia
        int left = dfs(root.left, dia);
        int right = dfs(root.right, dia);
        // we don't need to + 1 here because we count EDGES not NODES
        this.dia = Math.max(this.dia, (left + right));

        // 3. return the current height only! +1 for current node
        return Math.max(left, right) + 1;
    }
}
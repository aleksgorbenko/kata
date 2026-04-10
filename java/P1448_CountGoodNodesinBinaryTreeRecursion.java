// https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/

class P1448_CountGoodNodesinBinaryTreeRecursion {
    public int goodNodes(TreeNode root) {
        // need to know the largest value between
        // current Node and Root
        // we start with Root value
        return depthFirstSearch(root, root.val);
    }

    public int depthFirstSearch(TreeNode node, int maxSoFar) {
        // base case - we got to nulls, so we they will account as 0's
        if (node == null) {
            return 0;
        }

        // maxSoFar is a separate variable for each recursive function
        // at the bottom of the tree, these will return 0 - see Base Case
        // and we will move to the final lines of the method
        int left = depthFirstSearch(node.left, Math.max(node.val, maxSoFar));
        int right = depthFirstSearch(node.right, Math.max(node.val, maxSoFar));

        int answer = left + right;
        // add +1 for the current node
        // at the bottom of the tree this will finally start to return
        // all functions
        if (node.val >= maxSoFar) {
            answer++;
        }

        return answer;
    }
}
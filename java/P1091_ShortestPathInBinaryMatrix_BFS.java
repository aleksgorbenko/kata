import java.util.*; // ArrayList, HashMap, HashSet, Queue, PriorityQueue, etc.
import java.util.Arrays; // Arrays.sort(), Arrays.fill(), Arrays.asList()
import java.util.Collections; // Collections.sort(), Collections.reverseOrder()

// https://leetcode.com/problems/shortest-path-in-binary-matrix/description/

class State {
    public int row;
    public int col;
    public int steps;

    public State(int row, int col, int steps) {
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}

class P1091_ShortestPathInBinaryMatrix_BFS {
    private int[][] directions = new int[][] {
            // top,right,down,left
            { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 },
            // top-left, top-right, down-right, down-left
            { -1, 1 }, { 1, 1 }, { 1, -1 }, { -1, -1 }
    };
    private boolean[][] seen;

    public int shortestPathBinaryMatrix(int[][] grid) {
        // handle invalid inputs
        if (grid.length == 0 || grid[0][0] == 1) {
            return -1;
        }

        int n = grid.length;

        // init seen
        this.seen = new boolean[n][n];
        // init queue
        Queue<State> q = new ArrayDeque<>();
        // add first item to queue
        // Step is 1 when we start
        q.add(new State(0, 0, 1));

        // while loop - NO FOR loop inside like in TREES
        while (!q.isEmpty()) {
            var node = q.remove();
            // condition to return - we reached the end
            if (node.col == (n - 1) && node.row == (n - 1)) {
                // not sure if we need to + 1 yet
                // NO we don't - we increment steps at the time
                // when we add the node
                return node.steps;
            }

            // add all valid nodes to the queue
            for (int[] dir : directions) {
                int newRow = node.row + dir[0];
                int newCol = node.col + dir[1];
                // only process the nodes with
                // 0 - since it is valid path
                // always check for SEEN here too!
                if (isValid(newRow, newCol, n) &&
                        grid[newRow][newCol] == 0 &&
                        !this.seen[newRow][newCol]) {
                    // MARK SEEN WHEN ADDING
                    // IN DFS it is different from BFS
                    // as multiple nodes can try to add the same node again
                    // we need to mark it seen on the first encounter to avoid
                    // duplicate processing
                    this.seen[newRow][newCol] = true;
                    q.add(new State(newRow, newCol, node.steps + 1));
                }
            }
        }

        // we didn't reach the (n - 1, n - 1)
        return -1;
    }

    private boolean isValid(int row, int col, int len) {
        boolean validRow = 0 <= row && row < len;
        boolean validCol = 0 <= col && col < len;

        return validRow && validCol;
    }
}
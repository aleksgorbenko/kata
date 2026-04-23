
// ArrayList, HashMap, HashSet, Queue, PriorityQueue, etc.
import java.lang.foreign.AddressLayout;
import java.util.ArrayDeque;
import java.util.Queue;

// https://leetcode.com/problems/01-matrix/description/

class State {
    int row;
    int col;
    int steps;

    State(int row, int col, int steps) {
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}

class P542_01Matrix_Queue_BFS_MultiSource {
    private boolean[][] seen;
    private int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int[][] updateMatrix(int[][] mat) {
        // If we perform a BFS starting from all the zeros
        // whenever we encounter a 1, we know that
        // the current number of steps is the answer for that 1

        int rows = mat.length;
        int cols = mat[0].length;
        // init seen
        this.seen = new boolean[rows][cols];

        // init queue
        // WE NEED QUEUE because of BFS?
        Queue<State> q = new ArrayDeque<>();

        // will be filled with 0s
        // we can only assign new values
        // for 1s in original mat
        int[][] ans = new int[rows][cols];

        // MULTI SOURCE MEANS THAT WE DO NOT ADD
        // 0,0 item to queue first, we need to ADD
        // all 0s, which is MULTI SOURCE!!

        // DOUBLE LOOP
        // ADD ALL ITEMS to queue first
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                boolean valid = isValidPath(row, col, mat);
                // only capture all 0 to start from?
                if (valid && !this.seen[row][col] && mat[row][col] == 0) {
                    this.seen[row][col] = true;
                    q.offer(new State(row, col, 0));
                }
            }
        }

        // traverse matrix from all items in queue
        while (!q.isEmpty()) {
            var state = q.poll();
            // base case - capture the change in ans
            if (mat[state.row][state.col] != 0) {
                ans[state.row][state.col] = state.steps;
            }

            for (int[] dir : directions) {
                int newRow = state.row + dir[0];
                int newCol = state.col + dir[1];
                boolean valid = isValidPath(newRow, newCol, mat);
                // loop through all directions and add them to queue
                // if we haven't seen the node
                if (valid && !this.seen[newRow][newCol]) {
                    this.seen[newRow][newCol] = true;
                    q.offer(new State(newRow, newCol, state.steps + 1));
                }
            }
        }

        return ans;
    }

    private boolean isValidPath(int row, int col, int[][] mat) {
        boolean validRow = 0 <= row && row < mat.length;
        boolean validCol = 0 <= col && col < mat[0].length;

        return validRow && validCol;
    }
}
import java.util.*;        // ArrayList, HashMap, HashSet, Queue, PriorityQueue, etc.
import java.util.Arrays;   // Arrays.sort(), Arrays.fill(), Arrays.asList()
import java.util.Collections; // Collections.sort(), Collections.reverseOrder()

// https://leetcode.com/problems/number-of-islands/description/

// if connected - it is an island
// LEFT  (row - 1, col)
// RIGHT (row + 1, col)
// UP    (row, col + 1)
// DOWN  (row, col - 1)

class P200_NumberofIslands {
    // holds the coordinate deltas to move in the four directions.
    // up, right, down, left - clockwise
    // useful when input is matrix with coordinates
    private int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private boolean[][] seen;

    private int width;
    private int height;

    public int numIslands(char[][] grid) {
        this.height = grid.length;
        this.width = grid[0].length;

        int answer = 0;

        // No GRAPH, we just need to track what we visited
        this.seen = new boolean[this.height][this.width];
        // Double loop
        for (int row = 0; row < this.height; row++) {
            for (int col = 0; col < this.width; col++) {
                // grid[row][col] - FIRST ROW, then COL
                // seen MIRRORS the same grid!
                if (grid[row][col] == '1' && !this.seen[row][col]) {
                    // always MARK as SEEN first
                    this.seen[row][col] = true;
                    // if we are here - we found a new island
                    answer++;
                    // 2. DFS the adjacents coordinates
                    dfs(row, col, grid);
                }
            }
        }

        System.out.printf("seen is %s%n", java.util.Arrays.deepToString(this.seen));
        return answer;
    }

    public boolean isValid(int row, int col, char[][] grid) {
        boolean validRow = 0 <= row && row < this.height;
        boolean validCol = 0 <= col && col < this.width;
        // only if coordinates are valid
        // we can check if it is 1
        if (validRow && validCol) {
            return grid[row][col] == '1';
        }

        return false;
    }

    public void dfs(int row, int col, char[][] grid) {
        // we need to check every adjacent node based on all 4 directions
        for (int[] direction : this.directions) {
            int nextRow = row + direction[0]; // direction[0] is always X axis
            int nextCol = col + direction[1]; // direction[1] is always Y axis
            boolean validLand = isValid(nextRow, nextCol, grid);
            
            // if valid and not seen before
            if (validLand && !this.seen[nextRow][nextCol]) {
                // Always MARK first
                this.seen[nextRow][nextCol] = true;
                dfs(nextRow, nextCol, grid);
            }
        }
    }
}

// ArrayList, HashMap, HashSet, Queue, PriorityQueue, etc.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/number-of-provinces/description/

class P547_NumberofProvinces {
    private Map<Integer, List<Integer>> map = new HashMap<>();
    private boolean[] seen;

    public int findCircleNum(int[][] isConnected) {
        // 1. create a hashmap graph from adjency matrix
        int n = isConnected.length;
        this.seen = new boolean[n];

        for (int i = 0; i < n; i++) {
            // create entry if doesn't exist
            if (!this.map.containsKey(i)) {
                this.map.put(i, new ArrayList<>());
            }
            // get each row
            // j = i + 1 is because matrix is symmetric
            for (int j = 0; j < n; j++) {
                // create entry if doesn't exist
                if (!this.map.containsKey(j)) {
                    this.map.put(j, new ArrayList<>());
                }

                if (isConnected[i][j] == 1) {
                    map.get(i).add(j);
                    map.get(j).add(i);
                }
            }
        }

        // 2. we have the graph built now

        // 3 traverse the graph and count provinces
        int provinces = 0;

        // for every node we need to do a DFS
        for (int i = 0; i < n; i++) {
            // if we haven't seen the node
            // this is a new province
            if (!seen[i]) {
                provinces++;
                // mark node as seen
                // always mark it BEFORE traversal
                seen[i] = true;
                dfs(i);
            }
        }

        return provinces;
    }

    private void dfs(int node) {
        // get the graph for the node
        for (int neighbour : this.map.get(node)) {
            if (!seen[neighbour]) {
                // mark as seen
                seen[neighbour] = true;
                // recursively check neighbour neighbous
                // until we we mark all as seen
                dfs(neighbour);
            }
        }
        // after this exits, we visited all nodes in a province and marked
        // all nodes as seen
    }
}
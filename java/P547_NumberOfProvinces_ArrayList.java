
// Arrays.sort(), Arrays.fill(), Arrays.asList()
// Collections.sort(), Collections.reverseOrder()
import java.util.*; // ArrayList, HashMap, HashSet, Queue, PriorityQueue, etc.

// https://leetcode.com/problems/number-of-provinces/description/

class P547_NumberOfProvinces_ArrayList {
    private int count;
    private List<List<Integer>> graph = new ArrayList<>();
    private boolean[] seen;

    public int findCircleNum(int[][] isConnected) {
        // input - matrix
        int n = isConnected.length;

        // preppopulate graph
        for (int i = 0; i < n; i++) {
            this.graph.add(new ArrayList<>());
        }

        // bi directinal graph
        // double loop
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[j][i] == 1) {
                    this.graph.get(i).add(j);
                    this.graph.get(j).add(i);
                }
            }
        }

        this.seen = new boolean[n];

        // parse the graph and count every new edge we see
        // since we have DFS, we will mark ALL nodes as SEEN that are connected
        // to the given node. On every iteration, IF the "i" node is NOT SEEN
        // we increment the counter, since this is a NEW GRAPH COMPONENT
        for (int i = 0; i < n; i++) {
            if (!this.seen[i]) {
                this.seen[i] = true;
                this.count++;
                dfs(i);
            }
        }

        return this.count;
    }

    public void dfs(int node) {
        for (int edge : this.graph.get(node)) {
            if (!this.seen[edge]) {
                this.seen[edge] = true;
                dfs(edge);
            }
        }
    }
}
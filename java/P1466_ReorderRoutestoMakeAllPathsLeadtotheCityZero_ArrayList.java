
// ArrayList, HashMap, HashSet, Queue, PriorityQueue, etc.
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/

class P1466_ReorderRoutestoMakeAllPathsLeadtotheCityZero_ArrayList {
    private boolean[] seen;
    private Set<String> roads = new HashSet<>();
    private List<List<Integer>> graph = new ArrayList<>();

    public int minReorder(int n, int[][] connections) {
        for (int i = 0; i < n; i++) {
            this.graph.add(new ArrayList<>());
        }

        // create BI-DIRECTIONAL graph
        for (int[] edge : connections) {
            this.graph.get(edge[0]).add(edge[1]);
            this.graph.get(edge[1]).add(edge[0]);
            this.roads.add(edge[0] + "," + edge[1]);
        }

        this.seen = new boolean[n];
        this.seen[0] = true;
        return dfs(0);
    }

    private int dfs(int node) {
        int ans = 0;
        for (int neighbour : this.graph.get(node)) {
            if (!this.seen[neighbour]) {
                this.seen[neighbour] = true;
                // return how many raod flips needed
                int flips = dfs(neighbour);
                ans += flips;

                if (this.roads.contains(node + "," + neighbour)) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
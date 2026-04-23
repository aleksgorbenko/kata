
// ArrayList, HashMap, HashSet, Queue, PriorityQueue, etc.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/

class P1466_ReorderRoutestoMakeAllPathsLeadtotheCityZero_HashMap {
    private boolean[] seen;
    private Set<String> roads = new HashSet<>();
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public int minReorder(int n, int[][] connections) {
        // populate graph with the connections
        // Adjency List
        for (int[] edge : connections) {
            int from = edge[0];
            int to = edge[1];
            this.graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            // creating a bi-directional Adjency List
            this.graph.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
            this.roads.add(stringify(edge[0], edge[1]));
        }

        this.seen = new boolean[n];
        this.seen[0] = true;

        return dfs(0);
    }

    public int dfs(int node) {
        int ans = 0;
        for (int neighbour : this.graph.get(node)) {
            if (!this.seen[neighbour]) {
                // 1. MARK THE NODE AS SEEN AT ALL TIMES!
                // HOW MANY TIMES I NEED TO LEARN THAT!
                this.seen[neighbour] = true;
                // add flips to the currenr answer
                int flips = dfs(neighbour);
                ans += flips;

                // if the edge exists in the original road
                // add 1 more flip
                String edge = stringify(node, neighbour);
                if (this.roads.contains(edge)) {
                    ans++;
                }

            }
        }

        return ans;
    }

    private String stringify(int from, int to) {
        return String.valueOf(from) + "," + String.valueOf(to);
    }
}
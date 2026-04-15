import java.util.*;        // ArrayList, HashMap, HashSet, Queue, PriorityQueue, etc.
import java.util.Arrays;   // Arrays.sort(), Arrays.fill(), Arrays.asList()
import java.util.Collections; // Collections.sort(), Collections.reverseOrder()

// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/

class P1466_ReorderRoutestoMakeAllPathsLeadtotheCityZero {
    private boolean[] seen;
    private List<List<int[]>> graph = new ArrayList<>();
    public int minReorder(int n, int[][] connections) {
        // one direction edges only

        // input is Edge List

        // build a List<List<Integer>> graph?
        // No... apparently we need to build List<List<int[]>>! 
        // int[]{neighbourNode, needFlip?}
        // needFlip is boolean represented as 0 or 1
        
        for (int i = 0; i < n;i++) {
            this.graph.add(new ArrayList<>());
        }

        // we build a bi-directional graph from Edge List
        // to Edge List AND we keep if we need to flip the road
        // this.graph.get(from).add(new int[]{to, 1}); - this means we need to flip it
        for (int[] edge : connections) {
            int from = edge[0];
            int to = edge[1]; // referred as "neighbour" in dfs method
            this.graph.get(from).add(new int[]{to, 1});
            // store reverse path, we don't need to flip it
            // if it is already flipped? i don't know...
            this.graph.get(to).add(new int[]{from, 0});
        }

        // mark 0 node as seen
        this.seen = new boolean[n];
        this.seen[0] = true;
        return dfs(0);
        // start from 0 and reverse every item that 0 points, to
        // recursively reverse the following item, e.g 1 (which was just reversed)
        // to 
    }

    public int dfs(int node) {
        int numberOfFlips = 0;
        for (int[] edge : this.graph.get(node)) {
            int neighbour = edge[0];
            int needsFlip = edge[1];
            if (!this.seen[neighbour]) {
                // always mark as seen before processing
                this.seen[neighbour] = true;
                int moreFlips = dfs(neighbour);
                numberOfFlips += needsFlip + moreFlips;
            }
            
        }

        return numberOfFlips;
    }
}
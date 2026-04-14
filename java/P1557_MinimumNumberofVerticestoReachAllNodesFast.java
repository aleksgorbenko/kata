import java.util.*;        // ArrayList, HashMap, HashSet, Queue, PriorityQueue, etc.
import java.util.Arrays;   // Arrays.sort(), Arrays.fill(), Arrays.asList()
import java.util.Collections; // Collections.sort(), Collections.reverseOrder()

// https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/description/

class P1557_MinimumNumberofVerticestoReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // handle null
        List<Integer> ans = new ArrayList<>();
        if (edges.size() == 0 || n == 0) {
            return ans;
        }

        // index -> node number
        // value -> count of incoming edges into the node
        int[] indegreeCount = new int[n];
        // count how many incoming edges 
        for (List<Integer> edge : edges) {
            indegreeCount[edge.get(1)]++;
        }

        // filter nodes with 0 incoming edges
        for (int i = 0;i < n; i++) {
            if (indegreeCount[i] == 0) {
                ans.add(i);
            }
        }

        return ans;
    }
}
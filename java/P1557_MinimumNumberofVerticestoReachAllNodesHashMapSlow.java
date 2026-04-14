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

        // save all FROM edges
        Map<Integer, Boolean> mapOfFrom = new HashMap<>();
        for (List<Integer> edge : edges) {
            mapOfFrom.put(edge.get(0), true);
        }
        
        // input - edge list - nothing to transform to
        
        // count the indegree nodes only
        // indegree are nodes that don't have anything to pointing to them
        // remove items from map if there are any TO edges pointing to it
        for (List<Integer> edge : edges) {
            mapOfFrom.remove(edge.get(1));
        }

        // time complexity is high, since we iterate twice

        return new ArrayList<>(mapOfFrom.keySet());
    }
}
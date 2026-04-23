
// ArrayList, HashMap, HashSet, Queue, PriorityQueue, etc.
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/description/

class P1557_MinimumNumberofVerticestoReachAllNodes_SetSlow {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // handle null
        List<Integer> ans = new ArrayList<>();
        if (edges.size() == 0 || n == 0) {
            return ans;
        }

        // save all FROM and TO edges
        HashSet<Integer> setOfFrom = new HashSet<>();
        HashSet<Integer> setOfTo = new HashSet<>();
        for (List<Integer> edge : edges) {
            setOfFrom.add(edge.get(0));
            setOfTo.add(edge.get(1));
        }

        // input - edge list - nothing to transform to

        // Set union - we need
        setOfFrom.removeAll(setOfTo);

        // time complexity is high, since we iterate twice

        return new ArrayList<>(setOfFrom);
    }
}
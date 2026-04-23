
// ArrayList, HashMap, HashSet, Queue, PriorityQueue, etc.
import java.util.List;

// https://leetcode.com/problems/keys-and-rooms/description/

class P841_KeysandRooms {
    private boolean[] seen;
    private int counter;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // input is Adjency List
        // we can use it directly i think since it is 0,n-1
        this.counter = rooms.size();
        this.seen = new boolean[this.counter];
        // first room is seen
        this.seen[0] = true;
        // mark first room as visited
        this.counter--;

        dfs(0, rooms);

        return this.counter == 0;
    }

    // 2. we will use dfs
    public void dfs(int node, List<List<Integer>> rooms) {
        for (int neighbour : rooms.get(node)) {
            // if we have seen it, we don't have
            // ot visit again
            if (!this.seen[neighbour]) {
                // mark as seen ALWAYS FIRST
                this.seen[neighbour] = true;
                this.counter--;
                dfs(neighbour, rooms);
            }
        }
    }
}
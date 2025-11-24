import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/path-crossing/description/
class Solution {
    public boolean isPathCrossing(String path) {
        int[] coords = new int[]{0, 0};
        HashSet<String> visited = new HashSet();
        visited.add(coordsToKey(coords));
        
        for (char c : path.toCharArray()) {
            switch (c) {
                case 'N':
                    coords[1]++;
                    break;
                case 'S':
                    coords[1]--;
                    break;
                case 'E':
                    coords[0]++;
                    break;
                case 'W':
                    coords[0]--;
                    break;
            }

            String key = coordsToKey(coords);
            if (visited.contains(key)) {
                return true;
            }

            visited.add(key);
        }

        return false;
    }

    private String coordsToKey(int[]coords) {
        return coords[0] + "," + coords[1];
    }
}
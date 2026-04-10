import java.util.HashSet;

// https://leetcode.com/problems/path-crossing/description/
class P1496_PathCrossing {
    public boolean isPathCrossing(String path) {
        int[] coords = new int[]{0, 0};
        HashSet<String> visited = new HashSet<>();
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

    public static void main(String[] args) {
        P1496_PathCrossing sol = new P1496_PathCrossing();
        System.out.println(sol.isPathCrossing("NES"));   // false
        System.out.println(sol.isPathCrossing("NESWW")); // true
    }
}

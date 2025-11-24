import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/destination-city/description/
class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String, Boolean> outgoing = new HashMap();
        HashSet<String> dest = new HashSet();

        for (List<String> path : paths) {
            String from = path.get(0);
            String to = path.get(1);
            dest.add(to);
            outgoing.put(from, true);
        }

        for (String d : dest) {
            if (outgoing.get(d) == null) {
                return d;
            }
        }

        return "";
    }
}
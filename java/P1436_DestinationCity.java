import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/destination-city/description/
class P1436_DestinationCity {
    public String destCity(List<List<String>> paths) {
        HashMap<String, Boolean> outgoing = new HashMap<>();
        HashSet<String> dest = new HashSet<>();

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

    public static void main(String[] args) {
        P1436_DestinationCity sol = new P1436_DestinationCity();
        List<List<String>> paths = List.of(
                List.of("London", "New York"),
                List.of("New York", "Lima"),
                List.of("Lima", "Sao Paulo"));
        System.out.println(sol.destCity(paths)); // Sao Paulo
    }
}

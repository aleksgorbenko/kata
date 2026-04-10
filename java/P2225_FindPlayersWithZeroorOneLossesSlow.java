import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/find-players-with-zero-or-one-losses/description/
class P2225_FindPlayersWithZeroorOneLossesSlow {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> onlyWinners = new ArrayList<>();
        List<Integer> onlylostOne = new ArrayList<>();
        // map: playerId -> {winCount, loseCount}
        // HashMap<Integer, List<Integer, Integer>> matchResults = new HashMap<>();
        HashMap<Integer, Integer> winCount = new HashMap<>();
        HashMap<Integer, Integer> loseCount = new HashMap<>();

        // store all results
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            winCount.put(winner, winCount.getOrDefault(winner, 0) + 1);
            loseCount.put(loser, loseCount.getOrDefault(loser, 0) + 1);
        }

        // loop through all winners and store in res only
        // the ones that won more than once
        for (Map.Entry<Integer, Integer> entry : winCount.entrySet()) {
            if (!loseCount.containsKey(entry.getKey())) {
                onlyWinners.add(entry.getKey());
            }
        }

        for (Map.Entry<Integer, Integer> entry : loseCount.entrySet()) {
            if (loseCount.containsKey(entry.getKey()) && loseCount.get(entry.getKey()) == 1) {
                onlylostOne.add(entry.getKey());
            }
        }
        Collections.sort(onlyWinners);
        Collections.sort(onlylostOne);
        res.add(onlyWinners);
        res.add(onlylostOne);

        return res;
    }

    public static void main(String[] args) {
        P2225_FindPlayersWithZeroorOneLossesSlow sol = new P2225_FindPlayersWithZeroorOneLossesSlow();
        System.out.println(sol.findWinners(new int[][]{{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}}));
    }
}

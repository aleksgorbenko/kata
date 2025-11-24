import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/description/
class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < cards.length; i++) {
            int key = cards[i];
            if (map.containsKey(key)) {
                ans = Math.min(ans, i - map.get(key) + 1);
            }

            map.put(key, i);
        }

        if (ans == Integer.MAX_VALUE) {
            return -1;
        }

        return ans;
    }
}
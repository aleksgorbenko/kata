import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/description/
class P2260_MinimumConsecutiveCardstoPickUpSlow {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < cards.length; i++) {
            if (!map.containsKey(cards[i])) {
                map.put(cards[i], new ArrayList<>(Arrays.asList(i)));
            } else {
                map.get(cards[i]).add(i);
            }
        }

        int ans = Integer.MAX_VALUE;

        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            // we need list.size() - 1 as we will be looking at
            // list[i+1] which will be our right element
            for (int i = 0; i < list.size() - 1; i++) {
                // classic formular for subarray size
                // right - left + 1
                ans = Math.min(ans, list.get(i+1) - list.get(i) + 1);
            }
        }

        if (ans == Integer.MAX_VALUE) {
            return -1;
        } else {
            return ans;
        }
    }

    public static void main(String[] args) {
        P2260_MinimumConsecutiveCardstoPickUpSlow sol = new P2260_MinimumConsecutiveCardstoPickUpSlow();
        System.out.println(sol.minimumCardPickup(new int[]{3, 4, 2, 3, 4, 7})); // 4
    }
}

import java.util.HashMap;

// https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/description/
class P2260_MinimumConsecutiveCardstoPickUpFast {
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

    public static void main(String[] args) {
        P2260_MinimumConsecutiveCardstoPickUpFast sol = new P2260_MinimumConsecutiveCardstoPickUpFast();
        System.out.println(sol.minimumCardPickup(new int[]{3, 4, 2, 3, 4, 7})); // 4
    }
}

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/sum-of-unique-elements/description/
class P1748_SumofUniqueElements {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                ans += e.getKey();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        P1748_SumofUniqueElements sol = new P1748_SumofUniqueElements();
        System.out.println(sol.sumOfUnique(new int[]{1, 2, 3, 2})); // 4
    }
}

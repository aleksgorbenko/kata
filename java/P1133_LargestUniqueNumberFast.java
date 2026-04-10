import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/largest-unique-number/description/
class P1133_LargestUniqueNumberFast {
    public int largestUniqueNumber(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) +1);
        }

        int max = -1;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                max = Math.max(max, entry.getKey());
            }
        }

        return max;
    }

    public static void main(String[] args) {
        P1133_LargestUniqueNumberFast sol = new P1133_LargestUniqueNumberFast();
        System.out.println(sol.largestUniqueNumber(new int[]{5, 7, 3, 9, 4, 9, 8, 3, 1})); // 8
    }
}

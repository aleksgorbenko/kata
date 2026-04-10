import java.util.HashMap;
import java.util.HashSet;

// https://leetcode.com/problems/largest-unique-number/description/
class P1133_LargestUniqueNumberSlow {
    public int largestUniqueNumber(int[] nums) {
        HashSet<Integer> unique = new HashSet<>();
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            int currCount = count.get(num);
            if (currCount == 1) {
                unique.add(num);
            } else {
                unique.remove(num);
            }
        }

        int max = -1;
        for (int n : unique) {
            max = Math.max(max, n);
        }

        return max;
    }

    public static void main(String[] args) {
        P1133_LargestUniqueNumberSlow sol = new P1133_LargestUniqueNumberSlow();
        System.out.println(sol.largestUniqueNumber(new int[]{5, 7, 3, 9, 4, 9, 8, 3, 1})); // 8
    }
}

import java.util.HashMap;

// https://leetcode.com/problems/count-number-of-nice-subarrays/description/
class P1248_CountNumberofNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        // count = how many times each prefix-odd-count has appeared so far.
        // Key = how many odd numbers have we seen from the start up to some point in the array.
        // Value = how many times we have encountered this prefix count so far.
        HashMap<Integer, Integer> count = new HashMap<>();

        // we've seen 0 odd numbers 1 time — that's before the array starts.
        count.put(0, 1);
        // curr = running count of odd numbers
        int curr = 0;
        int res = 0;

        for (int num : nums) {
            // count how many odd numbers we see so far
            curr += num % 2;
            // If at some earlier point the prefix-sum was (curr - k),
            // then the subarray between that earlier point and now
            // has exactly k odd numbers.

            // curr - k is how many prefixes have exactly curr - k odd numbers.
            // Each of these prefixes can start a valid subarray ending at current index.
            res += count.getOrDefault(curr - k, 0);

            // store and increment how many times we saw a CURR number of odd items
            count.put(curr, count.getOrDefault(curr, 0) + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        P1248_CountNumberofNiceSubarrays sol = new P1248_CountNumberofNiceSubarrays();
        System.out.println(sol.numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3)); // 2
    }
}

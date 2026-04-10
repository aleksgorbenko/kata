import java.util.HashMap;

// https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/description/
class P2958_LengthofLongestSubarrayWithatMostKFrequency {
    public int maxSubarrayLength(int[] nums, int k) {
        int res = 0;
        int left = 0;
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            count.put(nums[right], count.getOrDefault(nums[right], 0) + 1);

            // The only frequency that can become too big at each step is
            // the one we just incremented.
            while (count.get(nums[right]) > k) {
                count.put(nums[left], count.get(nums[left]) - 1);
                if (count.get(nums[left]) == 0) {
                    count.remove(nums[left]);
                }
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        P2958_LengthofLongestSubarrayWithatMostKFrequency sol = new P2958_LengthofLongestSubarrayWithatMostKFrequency();
        System.out.println(sol.maxSubarrayLength(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2)); // 6
    }
}

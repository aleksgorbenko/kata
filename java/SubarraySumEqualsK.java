import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/subarray-sum-equals-k/description/
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // We pretend prefix sum 0 happened once before the array began.
        // This allows subarrays starting at index 0.
        map.put(0, 1);

        int answer = 0;
        int curr = 0;

        for (int num : nums) {
            // calculate prefix on the fly
            curr += num;
            // How many times did we see a prefix that would make a subarray ending here equal to k?
            answer += map.getOrDefault(curr - k, 0);
            // Record that we’ve now seen this prefix sum one more time.
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }

        return answer;
    }
}
// https://leetcode.com/problems/3sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();

        if (nums.length == 0) {
            return triplets;
        }

        HashMap<Integer, List<Integer>> dups = new HashMap<>();
        // sort that we can use 2 pointers approach
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            // if first number in sorted array is positive - we will never sum to 0.
            if (nums[i] > 0) {
                break;
            }
            // Find all pairs that sum to a target of '-a' (-nums[i]).
            // if a+b+c = 0 then b+c = -a
            List<List<Integer>> pairs = pairSumSortedAllPairs(nums, i + 1, -nums[i]);
            for (List<Integer> pair : pairs) {
                var pairCopy = new ArrayList<>(pair);
                // I have a feeling something is happening here.
                // 312/314 tests pass, the ones that fail, have 300Kb+ of output
                if (dups.get(pairCopy.hashCode()) == null) {
                    dups.put(pairCopy.hashCode(), pairCopy);
                    triplets.add(Arrays.asList(nums[i], pair.get(0), pair.get(1)));
                }

            }
        }
        return triplets;
    }

    public List<List<Integer>> pairSumSortedAllPairs(int[] nums, int start, int target) {
        List<List<Integer>> pairs = new ArrayList<>();
        int left = start, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                pairs.add(Arrays.asList(nums[left], nums[right]));
                left++;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return pairs;
    }
}

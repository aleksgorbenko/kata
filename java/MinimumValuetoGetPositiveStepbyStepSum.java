import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/description/
class Solution {
    public int minStartValue(int[] nums) {
        if (nums.length == 1) {
            if (nums[0] < 0) {
                return Math.abs(nums[0]) + 1;
            } else {
                return 1;
            }
            }

        // 1. build prefix array
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i=1;i<nums.length;i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }

        // 2. for every item in the prefix
        // increment minValue while it is less than 1
        int minValue = 1;
        for (int i = 0; i < prefix.length; i++) {
            while (prefix[i] + minValue < 1) {
                minValue++;
            }
        }

        return minValue;
    }
}
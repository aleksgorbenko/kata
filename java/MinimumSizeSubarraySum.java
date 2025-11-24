import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/minimum-size-subarray-sum/description/
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            if (nums[0] >= target) {
                return 1;
            } else {
                return 0;
            }
        }
        
        int left = 0;
        int curr = 0;
        int min = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            curr += nums[right];

            while (curr >= target) {
                min = Math.min(min, right - left + 1);
                curr -= nums[left];
                left++;
            }

        }

        return (min == Integer.MAX_VALUE) ? 0 : min;
    }
}
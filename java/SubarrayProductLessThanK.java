import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/subarray-product-less-than-k/description/
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // 1. if K 1 or less, we will always have 0 subarrays
        if (k <= 1) { 
            return 0;
        }

        int answer = 0;
        int left = 0;
        int current = 1; // initial multiplier

        // 2. sliding window
        for (int right = 0; right < nums.length; right++) {
            current *= nums[right];
            
            while (current >= k) {
                current /= nums[left];
                left++;
            }

            // 3. we add all subarrays as this formula represents
            // the number of subarrays between right and left
            answer += right - left + 1;
        }
    
        return answer;
    }
}
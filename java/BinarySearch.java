import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
// https://neetcode.io/problems/binary-search?list=neetcode150
class Solution {
    public int search(int[] nums, int target) {
        // 2 pointers
        var left = 0;
        var right = nums.length - 1;
        
        while (left <= right) {
            // int half = left + (right - left) / 2;
            int half = (right + left) / 2; // also works
            if (nums[half] == target) {
                return half;
            // move right index to half since target is in the lower part
            } else if (nums[half] > target) {
                right = half - 1;
            // move left index to half since target is in the higher part
            } else {
                left = half + 1;
            }
        }

        return -1;
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/contiguous-array/description/
class Solution {
    public int findMaxLength(int[] nums) {
        // The map remembers the earliest index where each count occurred.
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // pretend we have -1 at index 0. 
        
        int maxWindow = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            // +1 for 1 and -1 for 0
            count = count + (nums[i] == 1 ? 1 : -1);

            // we have equal 0 and 1 here, so we can reassign maxWindow
            if (count == 0) {
                maxWindow = i + 1;
            // if we saw the exact same count on a different index, then from that
            // previous index to the current index, we have a subarray with equal 1 and 0.
            } else if (map.containsKey(count)) {
                maxWindow = Math.max(maxWindow, i - map.get(count));
            } else {
                // store this specific count and index where we have encountered it
                map.put(count, i);
            }
        }
        
        return maxWindow;
    }
}
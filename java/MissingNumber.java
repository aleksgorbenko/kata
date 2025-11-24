import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/missing-number/description/
class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        
        for (int i : nums) {
            set.add(i);
        }
        
        if (!set.contains(len)) {
            return len;
        }
        
        for (int i = 0; i < len; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        
        return 0;
    }
}
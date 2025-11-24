import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/largest-unique-number/description/
class Solution {
    public int largestUniqueNumber(int[] nums) {
        HashSet<Integer> unique = new HashSet<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            int currCount = count.get(num);
            if (currCount == 1) {
                unique.add(num);
            } else {
                unique.remove(num);
            }
        }
        
        int max = -1;
        for (int n : unique) {
            max = Math.max(max, n);
        }
        
        return max;
    }
}
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/find-the-highest-altitude/description/
class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int len = gain.length;

        long[] prefix = new long[gain.length+1];
        for (int i=0; i< len; i++) {
            prefix[i+1] = prefix[i] + gain[i];
            max = (int) Math.max(max, prefix[i+1]);
        }

        return max;
    }
}
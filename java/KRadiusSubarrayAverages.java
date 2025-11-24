import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/k-radius-subarray-averages/description/
class Solution {
    public int[] getAverages(int[] nums, int k) {
        // both will be identical if k = 0
        if (k == 0) {
            return nums;
        }

        // if divisor is larger than the array
        // fill it up with -1 and return
        int len = nums.length;
        int[] answer = new int[len];
        int devisor = k*2+1;
        if (devisor > len) {
            for (int i = 0; i < len; i++) {
                answer[i] = -1;
            }
            return answer;
        }

        // 1. build prefix array with +1 offset
        // have extra element at the end so that later algorithm
        // doesn't crash
        long[] prefix = new long[len + 1];
        // prefix[0] = nums[0]; // we don't need this as we use +1 offset
        for (int i = 0; i < len; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        for (int i = 0; i < len; i++) {
            // set -1 if index is out of bounds, or less than 0
            if ((i + k >= len) || (i - k < 0)) {
                answer[i] = -1;
                continue;
            }

            long divisable = prefix[i+k+1] - prefix[i-k];
            long result = divisable / devisor;
            answer[i] = (int) result;
        }

        return answer;
    }
}
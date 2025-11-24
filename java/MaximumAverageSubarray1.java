import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/maximum-average-subarray-i/description/
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0.0;
        double maxAverage = 0.0;
        double answer = 0.0;

        // precumpute first k elements sum
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        maxAverage = sum / k;
        answer = maxAverage;

        // slide the window
        // add next element and
        // remove the first element of previous window
        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i-k];
            maxAverage = sum / k;
            answer = Math.max(answer, maxAverage);
        }

        return answer;
    }
}
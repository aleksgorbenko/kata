import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/find-pivot-index/description/
class Solution {
    public int pivotIndex(int[] nums) {
        // 1. build prefix
        int leftSum = 0;
        int rightSum = 0;

        // 1. total sum of all ints
        for (int i : nums) {
            rightSum += i;
        }

        // 2. substract num from rightSum and compare to leftSum
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (rightSum == leftSum) {
                return i;
            }
            //3. keep increasing leftSum for comparison in the next loop cycle
            leftSum += nums[i];
        }

        return -1;
    }
}
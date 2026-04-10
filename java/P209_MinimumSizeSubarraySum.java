// https://leetcode.com/problems/minimum-size-subarray-sum/description/

class P209_MinimumSizeSubarraySum {
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

    public static void main(String[] args) {
        P209_MinimumSizeSubarraySum sol = new P209_MinimumSizeSubarraySum();
        System.out.println(sol.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3})); // 2
    }
}

import java.util.Arrays;

// https://leetcode.com/problems/k-radius-subarray-averages/description/
class P2090_KRadiusSubarrayAverages {
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

    public static void main(String[] args) {
        P2090_KRadiusSubarrayAverages sol = new P2090_KRadiusSubarrayAverages();
        System.out.println(Arrays.toString(sol.getAverages(new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6}, 3))); // [-1,-1,-1,5,4,4,-1,-1,-1]
    }
}

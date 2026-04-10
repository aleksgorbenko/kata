// https://leetcode.com/problems/maximum-average-subarray-i/description/

class P643_MaximumAverageSubarray1 {
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

    public static void main(String[] args) {
        P643_MaximumAverageSubarray1 sol = new P643_MaximumAverageSubarray1();
        System.out.println(sol.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4)); // 12.75
    }
}

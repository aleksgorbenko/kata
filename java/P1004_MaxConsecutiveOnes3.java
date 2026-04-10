// https://leetcode.com/problems/max-consecutive-ones-iii/

class P1004_MaxConsecutiveOnes3 {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int zeros = 0;
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[right] == 0) {
                zeros++;
            }

            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            answer = Math.max(answer, right-left+1);
            right++;
        }

        return answer;
    }

    public static void main(String[] args) {
        P1004_MaxConsecutiveOnes3 sol = new P1004_MaxConsecutiveOnes3();
        System.out.println(sol.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2)); // 6
    }
}

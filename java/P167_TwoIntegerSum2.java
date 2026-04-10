// https://neetcode.io/problems/two-integer-sum-ii?list=neetcode150
import java.util.Arrays;

class P167_TwoIntegerSum2 {
    public int[] twoSum(int[] numbers, int target) {
        // init two pointers
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int curSum = numbers[left] + numbers[right];

            // since array is sorted if the sum is larger than target
            // we need move right pointer, closer to the left, so we can try summing up
            // with smaller values
            if (curSum > target) {
                right--;
            // same as with right pointer, but in reverse - we need to move
            // left pointer to the right to sum with larger values
            } else if (curSum < target) {
                left++;
            // we got our target, so we just increment the index, since we need to return
            // 1-indexed array
            } else {
                return new int[] { left + 1, right + 1 };
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        P167_TwoIntegerSum2 sol = new P167_TwoIntegerSum2();
        System.out.println(Arrays.toString(sol.twoSum(new int[]{2, 7, 11, 15}, 9))); // [1, 2]
    }
}

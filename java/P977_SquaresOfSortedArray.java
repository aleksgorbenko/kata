// https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/703/arraystrings/4689/
import java.util.Arrays;

class P977_SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int left = 0;
        int right = n - 1;
        int pos = n - 1;

    while (left <= right) {
        int leftSq = nums[left] * nums[left];
        int rightSq = nums[right] * nums[right];
        if (leftSq > rightSq) {
            result[pos--] = leftSq;
            left++;
        } else {
            result[pos--] = rightSq;
            right--;
        }
    }

    return result;
    }

    public static void main(String[] args) {
        P977_SquaresOfSortedArray sol = new P977_SquaresOfSortedArray();
        System.out.println(Arrays.toString(sol.sortedSquares(new int[]{-4, -1, 0, 3, 10}))); // [0,1,9,16,100]
    }
}

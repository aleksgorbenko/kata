// https://leetcode.com/problems/rotate-array/description/
class P189_RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int[] newNums = new int[n];

        for (int i = 0; i < n; i++) {
            // when (i+k) % n > n e.g 13 % 10
            // index will be 3, which effectively "wraps"
            // and starts from the beginning
            newNums[(i + k) % n] = nums[i];
        }

        // Java is pass by VALUE language, but
        // []int nums will pass a copy of the reference
        // nums = newNums - would not work, since "nums"
        // is a COPY of the reference.
        // Hence, we need to loop again and reassign the original
        // array with new values
        for (int i = 0; i < n; i++) {
            nums[i] = newNums[i];
        }
    }
}
// https://neetcode.io/problems/binary-search?list=neetcode150
class P704_BinarySearch {
    public int search(int[] nums, int target) {
        // 2 pointers
        var left = 0;
        var right = nums.length - 1;

        while (left <= right) {
            // int half = left + (right - left) / 2;
            int half = (right + left) / 2; // also works
            if (nums[half] == target) {
                return half;
            // move right index to half since target is in the lower part
            } else if (nums[half] > target) {
                right = half - 1;
            // move left index to half since target is in the higher part
            } else {
                left = half + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        P704_BinarySearch sol = new P704_BinarySearch();
        System.out.println(sol.search(new int[]{-1, 0, 3, 5, 9, 12}, 9)); // 4
        System.out.println(sol.search(new int[]{-1, 0, 3, 5, 9, 12}, 2)); // -1
    }
}

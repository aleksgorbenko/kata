// https://leetcode.com/problems/find-pivot-index/description/

class P724_FindPivotIndex {
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

    public static void main(String[] args) {
        P724_FindPivotIndex sol = new P724_FindPivotIndex();
        System.out.println(sol.pivotIndex(new int[]{1, 7, 3, 6, 5, 6})); // 3
    }
}

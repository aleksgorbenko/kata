import java.util.Arrays;
import java.util.HashMap;

// https://neetcode.io/problems/two-integer-sum?list=neetcode150
class P1_TwoSumFast {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> prevMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;

            if (prevMap.containsKey(diff)) {
                return new int[] { prevMap.get(diff), i };
            }

            prevMap.put(num, i);
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        P1_TwoSumFast sol = new P1_TwoSumFast();
        System.out.println(Arrays.toString(sol.twoSum(new int[]{2, 7, 11, 15}, 9))); // [0, 1]
    }
}

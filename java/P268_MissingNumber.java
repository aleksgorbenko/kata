import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/missing-number/description/
class P268_MissingNumber {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        if (!set.contains(len)) {
            return len;
        }

        for (int i = 0; i < len; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        P268_MissingNumber sol = new P268_MissingNumber();
        System.out.println(sol.missingNumber(new int[]{3, 0, 1})); // 2
    }
}

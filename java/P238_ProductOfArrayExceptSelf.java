// https://neetcode.io/problems/products-of-array-discluding-self?list=neetcode150
import java.util.Arrays;

class P238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        // calculate all prefix value and store in the result array
        // since we start with prefix of 1, we store in index 0 to begin with
        // therefore we we offset the multiples to the left by 1 position
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix = prefix * nums[i];
        }

        // calculate all postfix value and multiple each result by the same index in the result array
        int postfix = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            result[i] = result[i] * postfix;
            postfix = postfix * nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        P238_ProductOfArrayExceptSelf sol = new P238_ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(sol.productExceptSelf(new int[]{1, 2, 3, 4}))); // [24,12,8,6]
    }
}

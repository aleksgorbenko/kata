// https://bytebytego.com/exercises/coding-patterns/two-pointers/pair-sum-sorted
import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> pair_sum_sorted(ArrayList<Integer> nums, int target) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.size()-1; i++) {
            for (int j = i+1; j < nums.size(); j++) {
                if (target == nums.get(i) + nums.get(j)) {
                    result.add(i);
                    result.add(j);
                    return result;
                }
            }
        }

        return new ArrayList<Integer>();
    }
}
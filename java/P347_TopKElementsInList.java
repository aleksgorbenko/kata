// https://neetcode.io/problems/top-k-elements-in-list?list=neetcode150

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class P347_TopKElementsInList {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counter = new HashMap<>();

        @SuppressWarnings("unchecked")
        List<Integer>[] freq = new List[nums.length + 1];

        // init empty lists for frequency tracker
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        // count the frequency for every number in nums
        for (int i : nums) {
            counter.put(i, counter.getOrDefault(i, 0) + 1);
        }

        // store all nums in a list with the freq as their key
        // freq[2] = [1,4,5] - numbers 1,4,5 were repeated 2 times in nums
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        // we need to have a break condition, by tracking how many elements K we have
        // added to result
        // then we can stop once we have K elements
        // we start from the back of the freq array, since we want the most frequent
        // elements
        int[] result = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                result[index] = n;
                if (index == k) {
                    return result;
                }
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        P347_TopKElementsInList sol = new P347_TopKElementsInList();
        System.out.println(Arrays.toString(sol.topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2))); // [1, 2]
    }
}

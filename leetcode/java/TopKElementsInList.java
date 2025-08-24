// https://neetcode.io/problems/top-k-elements-in-list?list=neetcode150

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        List<Integer>[] freq = new List[nums.length+1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int i : nums) {
            counter.put(i, counter.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        // we need to have a break condition, by tracking how many elements we have added to result
        int[] result = new int[k];
        int index = 0;
        for (int i = freq.length-1; i > 0 && index < k; i--) {
            for (int n: freq[i]) {
                result[index++] = n;
                if (index == k) {
                    return result;
                }
                // index++;
            }
        }

        return result;
    }
}

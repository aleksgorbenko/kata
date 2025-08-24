// https://neetcode.io/problems/anagram-groups?list=neetcode150

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap();

        for (String s : strs) {
            var chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            // sorted string beomes a key to a lists
            res.putIfAbsent(sortedStr, new ArrayList());
            // add the current string to the list
            res.get(sortedStr).add(s);
        }
        // generate a list of lists of strings
        return new ArrayList<>(res.values());
    }
}

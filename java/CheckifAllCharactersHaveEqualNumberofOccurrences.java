import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/description/
class Solution {
    public boolean areOccurrencesEqual(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return true;
        }

        Map<Character, Integer> map = new HashMap<>();
        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int freq = map.get(s.charAt(0));
        for (Integer charFreq : map.values()) {
            if (freq != charFreq) {
                return false;
            }
        }

        return true;
    }
}
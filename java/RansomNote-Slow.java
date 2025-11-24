import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/ransom-note/description/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> ransomCount = new HashMap<>();

        for (char c: ransomNote.toCharArray()) {
            ransomCount.put(c, ransomCount.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> magCount = new HashMap<>();

        for (char c: magazine.toCharArray()) {
            magCount.put(c, magCount.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : ransomCount.entrySet()) {
            int countInRansom = entry.getValue();
            int countInMag = magCount.getOrDefault(entry.getKey(), 0);
            if (countInRansom > countInMag) {
                return false;
            }
        }

        return true;
    }
}
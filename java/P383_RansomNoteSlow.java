import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/ransom-note/description/
class P383_RansomNoteSlow {
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

    public static void main(String[] args) {
        P383_RansomNoteSlow sol = new P383_RansomNoteSlow();
        System.out.println(sol.canConstruct("aa", "aab")); // true
        System.out.println(sol.canConstruct("aa", "ab"));  // false
    }
}

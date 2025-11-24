import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/check-if-the-sentence-is-pangram/description/
class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        
        char[] charArr = sentence.toCharArray();
        int englishLettersTotal = 26;
        
        for (char c: charArr) {
            if (c == ' ') {
                continue;
            }
            
            if (!set.contains(c)) {
                set.add(Character.toLowerCase(c));
            }
            
            if (englishLettersTotal == set.size()) {
                return true;
            }
        }

        return false;
    }
}
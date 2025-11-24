import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/first-letter-to-appear-twice/description/
class Solution {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                return c;
            }

            set.add(Character.valueOf(c));
        }
        
        return ' ';
    }
}
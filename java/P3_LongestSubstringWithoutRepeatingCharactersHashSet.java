// https://neetcode.io/problems/longest-substring-without-duplicates?list=neetcode150
import java.util.HashSet;
import java.util.Set;

class P3_LongestSubstringWithoutRepeatingCharactersHashSet {
    public int lengthOfLongestSubstring(String s) {
        // 1. use Set to store all the characters
        Set<Character> charSet = new HashSet<>();
        int left = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            // 2. if we see character that is already in the set
            // remove it from the set and move left pointer by 1
            // to the right
            while (charSet.contains(s.charAt(i))) {
                System.out.println(String.format("char found in set: %s", s.charAt(i)));
                System.out.println(String.format("char found in set: %s", s.charAt(i)));
                System.out.println(String.format("removing char from set: %s", s.charAt(left)));
                charSet.remove(s.charAt(left));
                System.out.println(String.format("moving left to: %d", (left + 1)));
                left++;
            }
            // 3. add the current char to the set
            charSet.add(s.charAt(i));
            // 4. get max: either (current index - left pointer)
            // length or result stays as is
            result = Math.max(result, i - left + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        P3_LongestSubstringWithoutRepeatingCharactersHashSet sol = new P3_LongestSubstringWithoutRepeatingCharactersHashSet();
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));   // 3
    }
}

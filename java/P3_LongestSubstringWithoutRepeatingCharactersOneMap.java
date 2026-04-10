import java.util.HashMap;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
class P3_LongestSubstringWithoutRepeatingCharactersOneMap {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> counts = new HashMap<>();

        int left = 0;
        int res = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            counts.put(rightChar, counts.getOrDefault(rightChar, 0) + 1);

            while (counts.get(rightChar) > 1) {
                char leftChar = s.charAt(left);
                counts.put(leftChar, counts.get(leftChar) - 1);
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        P3_LongestSubstringWithoutRepeatingCharactersOneMap sol = new P3_LongestSubstringWithoutRepeatingCharactersOneMap();
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));   // 3
    }
}

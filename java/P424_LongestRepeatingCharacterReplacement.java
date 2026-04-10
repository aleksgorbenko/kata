import java.util.HashMap;

// https://leetcode.com/problems/longest-repeating-character-replacement/description/
class P424_LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        // 1. sliding window
        HashMap<Character, Integer> freq = new HashMap<>();

        int answer = 0;
        int maxFreq = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // 2. store count for every character
            char rightChar = s.charAt(right);
            freq.put(rightChar, freq.getOrDefault(rightChar, 0) + 1);
            // 3. re-assign maxFreq to the character that is the most frequent in our
            // freq map
            maxFreq = Math.max(maxFreq, freq.get(rightChar));

            // 4. while the size of the (window - maxFreq) is more than K
            // we can subtract the left character frequency and move window to the left
            while ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                left++;
            }

            // 5. re-calculate currLength as we just moved left++;
            // answer will be max of the current window size
            answer = Math.max(answer, (right - left + 1));
        }

        return answer;
    }

    public static void main(String[] args) {
        P424_LongestRepeatingCharacterReplacement sol = new P424_LongestRepeatingCharacterReplacement();
        System.out.println(sol.characterReplacement("ABAB", 2)); // 4
        System.out.println(sol.characterReplacement("AABABBA", 1)); // 4
    }
}

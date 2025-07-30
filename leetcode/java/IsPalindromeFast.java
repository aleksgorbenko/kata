// https://leetcode.com/problems/valid-palindrome/

class Solution {
    public boolean isPalindrome(String s) {
        System.out.println("string: " + s);
        if (s.isEmpty() || s.length() == 1) {
            return true;
        }
        int startPointer = 0;
        int endPointer = s.length()-1;

        while (startPointer<endPointer) {
            var startChar = s.charAt(startPointer);
            var endChar = s.charAt(endPointer);

            if (!Character.isLetterOrDigit(startChar)) {
                startPointer++;
            } else if (!Character.isLetterOrDigit(endChar)) {
                endPointer--;
            } else if (Character.toLowerCase(startChar) != Character.toLowerCase(endChar)) {
                return false;
            } else {
                // characters match, so we move pointers closer to each other
                // for next iteration
                startPointer++;
                endPointer--;
            }
        }

        return true;
    }
}

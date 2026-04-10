// https://leetcode.com/problems/valid-palindrome/

class P125_IsPalindromeFast {
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

    public static void main(String[] args) {
        P125_IsPalindromeFast sol = new P125_IsPalindromeFast();
        System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(sol.isPalindrome("race a car")); // false
    }
}

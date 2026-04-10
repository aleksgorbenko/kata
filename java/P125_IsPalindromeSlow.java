// https://leetcode.com/problems/valid-palindrome/

class P125_IsPalindromeSlow {
    public boolean isPalindrome(String s) {
        // Write your code here
        var cleanString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println("clean: " + cleanString);
        if (cleanString.isEmpty() || cleanString.length() == 1) {
            return true;
        }

        int length = cleanString.length()-1;
        for (int i = 0; i <= length; i++) {
            if (cleanString.charAt(i) != cleanString.charAt(length)) {
                return false;
            }
            length--;
        }

        return true;

    }

    public static void main(String[] args) {
        P125_IsPalindromeSlow sol = new P125_IsPalindromeSlow();
        System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(sol.isPalindrome("race a car")); // false
    }
}

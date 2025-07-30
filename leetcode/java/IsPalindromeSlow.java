// https://leetcode.com/problems/valid-palindrome/

class Solution {
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
}

// https://leetcode.com/problems/reverse-words-in-a-string-iii/description/

class P557_ReverseWordsInaStringIII {
    public String reverseWords(String s) {
        char space = ' ';
        int leftP = 0;
        int rightP = 0;

        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            // move to next space
            while (rightP < charArr.length && charArr[rightP] != space) {
                rightP++;
            }

            // reverse individual word
            int l = leftP;
            int r = rightP - 1;
            while (l < r) {
                char rightChar = charArr[r];
                charArr[r] = charArr[l];
                charArr[l] = rightChar;
                l++;
                r--;
            }

            // move on to next word
            rightP++;
            leftP = rightP;
        }

        return new String(charArr);
    }

    public static void main(String[] args) {
        P557_ReverseWordsInaStringIII sol = new P557_ReverseWordsInaStringIII();
        System.out.println(sol.reverseWords("Let's take LeetCode contest")); // s'teL ekat edoCteeL tsetnoc
    }
}

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/check-if-the-sentence-is-pangram/description/
class P1832_CheckiftheSentenceIsPangram {
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

    public static void main(String[] args) {
        P1832_CheckiftheSentenceIsPangram sol = new P1832_CheckiftheSentenceIsPangram();
        System.out.println(sol.checkIfPangram("thequickbrownfoxjumpsoverthelazydog")); // true
        System.out.println(sol.checkIfPangram("leetcode")); // false
    }
}

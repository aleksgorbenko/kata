import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/first-letter-to-appear-twice/description/
class P2351_FirstLettertoAppearTwice {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                return c;
            }

            set.add(c);
        }

        return ' ';
    }

    public static void main(String[] args) {
        P2351_FirstLettertoAppearTwice sol = new P2351_FirstLettertoAppearTwice();
        System.out.println(sol.repeatedCharacter("abccbaacz")); // c
    }
}

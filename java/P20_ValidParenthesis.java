import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

// https://neetcode.io/problems/validate-parentheses?list=neetcode150
class P20_ValidParenthesis {
    public boolean isValid(String str) {
        if (str.length() <= 1) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();
        var brackets = new HashMap<Character, Character>();
        brackets.put('[', ']');
        brackets.put('{', '}');
        brackets.put('(', ')');

        for (int i = 0; i < str.length(); i++) {
            var bracket = str.charAt(i);
            if (isOpeningBracket(bracket)) {
                stack.push(bracket);
            } else {
                // this means we only have closing brackets
                // in stack
                if (stack.size() == 0) {
                    return false;
                }
                // the current bracket we are iterting over
                // must match the stack head
                var lastBracket = stack.pop();
                var closingBracket = brackets.get(lastBracket);
                if (bracket != closingBracket) {
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }

    private boolean isOpeningBracket(char c) {
        return c == '[' || c == '{' || c == '(';
    }

    public static void main(String[] args) {
        P20_ValidParenthesis sol = new P20_ValidParenthesis();
        System.out.println(sol.isValid("()[]{}")); // true
        System.out.println(sol.isValid("(]")); // false
    }
}

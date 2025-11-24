import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://neetcode.io/problems/validate-parentheses?list=neetcode150
class ValidParenthesis {
    public boolean isValid(String str) {
        if (str.length() <= 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
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
}

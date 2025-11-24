// https://leetcode.com/problems/valid-parentheses/

func isValid(s string) bool {
    if len(s) <= 1 {
        return false
    }
    
    closeToOpen := make(map[rune]rune)
    closeToOpen[']'] = '['
    closeToOpen['}'] = '{'
    closeToOpen[')'] = '('

    stack := []rune{}

    for _, char := range s {
        if open, exists := closeToOpen[char]; exists {
            // If it's a closing bracket, check stack
            // Open bracket must match the previous element in slice
            if len(stack) == 0 || open != rune(stack[len(stack)-1]) {
                return false
            }
            
            // pop from stack
            stack = stack[:len(stack)-1]
        } else {
            // It's an opening bracket, push to stack
            stack = append(stack, char)
        }
    }

    return len(stack) == 0
}

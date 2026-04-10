// https://leetcode.com/problems/valid-parentheses/description/

package main

func isValid(s string) bool {
	matchingBracket := map[rune]rune{
		'{': '}',
		'[': ']',
		'(': ')',
	}
	reverseMatchingBracket := map[rune]rune{
		'}': '{',
		']': '[',
		')': '(',
	}

	var stack []rune

	for _, char := range s {
		_, ok := matchingBracket[char]
		if ok {
			stack = append(stack, char) // push Opening Bracket
		} else {
			// char is Closing Bracket here
			// if stack is empty - return false
			if len(stack) == 0 {
				return false
			}

			// last char must be Opening Bracket
			// of the same type
			lastChar := stack[len(stack)-1]
			shouldBeOpeningBracket := reverseMatchingBracket[char]
			// if matches - pop the last element
			if lastChar == shouldBeOpeningBracket {
				stack = stack[:len(stack)-1]
			} else {
				return false
			}
		}
	}

	return len(stack) == 0
}

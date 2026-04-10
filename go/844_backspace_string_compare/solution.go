// https://leetcode.com/problems/backspace-string-compare/description/

package main

func backspaceCompare(s string, t string) bool {
	if len(s) == 0 && len(t) == 0 {
		return true
	}

	return finalString(s) == finalString(t)
}

func finalString(s string) string {
	backspace := '#'
	var stack []rune

	for _, ch := range s {
		if len(stack) > 0 && ch == backspace {
			stack = stack[:len(stack)-1]
		}

		if ch != backspace {
			stack = append(stack, ch)
		}
	}

	return string(stack)
}

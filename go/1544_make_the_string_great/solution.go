// https://leetcode.com/problems/make-the-string-great/description/

package main

import "unicode"

func makeGood(s string) string {
	if len(s) == 0 || len(s) == 1 {
		return s
	}

	var stack []rune
	for _, ch := range s {
		// if same - pop and continue
		if len(stack) > 0 {
			// if chars are equal
			previousChar := stack[len(stack)-1]
			sameLetter := unicode.ToLower(ch) == unicode.ToLower(previousChar)
			differentCase := unicode.IsLower(ch) != unicode.IsLower(previousChar)

			if sameLetter && differentCase {
				stack = stack[:len(stack)-1]
				continue
			}
		}

		stack = append(stack, ch)
	}

	return string(stack)
}

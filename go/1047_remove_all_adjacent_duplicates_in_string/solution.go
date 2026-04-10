// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/

package main

func removeDuplicates(s string) string {
	if len(s) < 2 {
		return s
	}

	var stack []rune

	for _, ch := range s {
		if len(stack) > 0 {
			if ch == stack[len(stack)-1] {
				// pop the latest char if they are the same as current
				stack = stack[:len(stack)-1]
				// continue to next char
				continue
				// if they are the same as current
			}
		}

		stack = append(stack, ch)
	}

	return string(stack)
}

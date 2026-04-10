// https://leetcode.com/problems/simplify-path/description/

package main

import "strings"

func simplifyPath(path string) string {
	if len(path) == 0 {
		return ""
	}

	pathParts := strings.Split(path, "/")
	var stack []string
	for _, part := range pathParts {
		// skip the item
		if part == "." || part == "/" || part == "" {
			continue
		}

		// pop previous dir
		if part == ".." {
			if len(stack) > 0 {
				stack = stack[:len(stack)-1]
			}
			continue
		}

		stack = append(stack, part)
	}

	return "/" + strings.Join(stack, "/")
}

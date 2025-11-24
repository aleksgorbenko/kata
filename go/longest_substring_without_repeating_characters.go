package main

// https://neetcode.io/problems/longest-substring-without-duplicates?list=neetcode150

func lengthOfLongestSubstring(str string) int {
	charSet := make(map[byte]bool)
	result := 0
	left := 0

	for right := 0; right < len(str); right++ {
		for charSet[str[right]] {
			delete(charSet, str[left])
			left++
		}
		charSet[str[right]] = true
		result = max(result, right-left+1)
	}

	return result
}

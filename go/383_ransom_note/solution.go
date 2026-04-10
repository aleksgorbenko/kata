// https://leetcode.com/problems/ransom-note/description/

package main

func canConstruct(ransomNote string, magazine string) bool {
	noteLetters := make(map[rune]int)
	// magazineLetters := make(map[string]int)

	// get note letter count
	for _, letter := range ransomNote {
		if _, ok := noteLetters[letter]; ok {
			noteLetters[letter] = noteLetters[letter] + 1
		} else {
			noteLetters[letter] = 1
		}
	}

	// get magazine letter count
	for _, letter := range magazine {
		if _, ok := noteLetters[letter]; ok {
			noteLetters[letter] = noteLetters[letter] - 1
		} else {
			continue
		}
	}

	// if some of the note letter are above 0 - we cannot construct a note
	for _, v := range noteLetters {
		if v > 0 {
			return false
		}
	}

	return true
}

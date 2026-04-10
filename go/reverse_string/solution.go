// https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/703/arraystrings/4592/

package main

import "fmt"

func reverseString(s []byte) {
	result := make([]byte, len(s))
	counter := len(s) - 1
	for _, item := range s {
		result[counter] = item
		counter--
	}
	copy(s, result)
}

func main() {
	s := []byte{'h', 'e', 'l', 'l', 'o'}
	reverseString(s)
	fmt.Println(string(s)) // olleh
}

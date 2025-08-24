// https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/703/arraystrings/4592/

func reverseString(s []byte) {
	result := make([]byte, len(s))
	counter := len(s) - 1
	for _, item := range s {
		result[counter] = item
		counter--
	}
	copy(s, result)
}
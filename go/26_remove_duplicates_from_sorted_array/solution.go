// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

package main

func removeDuplicates(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	writePos := 0

	for readPos := 1; readPos < len(nums); readPos++ {
		if nums[readPos] != nums[writePos] {
			writePos++
			nums[writePos] = nums[readPos]
		}
	}

	return writePos + 1
}

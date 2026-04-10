// https://leetcode.com/problems/rotate-array/description/

package main

func rotate(nums []int, k int) {
	n := len(nums)
	if k == 0 || k == n {
		return
	}

	k = k % n

	for i := 0; i < k; i++ {
		// save last element
		lastElement := nums[n-1]

		// shift all elements to the right
		// j - last element
		// j-1 - berfore-last element
		for j := n - 1; j > 0; j-- {
			nums[j] = nums[j-1]
		}

		// set last element to the first element
		nums[0] = lastElement
	}
}

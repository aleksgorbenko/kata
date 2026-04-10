// https://leetcode.com/problems/maximum-average-subarray-i/description/

package main

import "fmt"

func findMaxAverage(nums []int, k int) float64 {
	sum := 0.0
	maxAverage := 0.0

	// pre-compute window
	for i := 0; i < k; i++ {
		sum += float64(nums[i])
	}

	maxAverage = sum / float64(k)

	// range over with sliding window of k
	// remove last item, add next item in
	// window.
	for i := k; i < len(nums); i++ {
		sum = sum - float64(nums[i-k]) + float64(nums[i])
		avg := sum / float64(k)
		if avg > maxAverage {
			maxAverage = avg
		}
	}

	return maxAverage
}

func main() {
	fmt.Println(findMaxAverage([]int{1, 12, -5, -6, 50, 3}, 4)) // 12.75
	fmt.Println(findMaxAverage([]int{5}, 1))                     // 5.0
}

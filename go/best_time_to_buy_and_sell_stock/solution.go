// https://neetcode.io/problems/buy-and-sell-crypto?list=neetcode150

package main

import "fmt"

func maxProfit(prices []int) int {
	left := 0
	right := 1
	maxProfit := 0

	for right < len(prices) {
		if prices[left] < prices[right] {
			profit := prices[right] - prices[left]
			maxProfit = max(profit, maxProfit)
		} else {
			left = right
		}

		right++
	}

	return maxProfit
}

func main() {
	fmt.Println(maxProfit([]int{7, 1, 5, 3, 6, 4})) // 5
	fmt.Println(maxProfit([]int{7, 6, 4, 3, 1}))     // 0
}

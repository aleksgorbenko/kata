package main

// https://neetcode.io/problems/buy-and-sell-crypto?list=neetcode150

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

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

package main

func maxProfit(prices []int) int {
	// very badly worded problem! "However, you can sell and buy the stock multiple times on the same day, ensuring you never hold more than one share of the stock"

	n := len(prices)
	if n == 0 {
		return 0
	}

	// we need to capture every upward movement and buy/sell combining the profits
	maxProfit := 0
	for i := 0; i < n-1; i++ {
		if prices[i] < prices[i+1] {
			maxProfit += prices[i+1] - prices[i]
		}
	}

	return maxProfit
}

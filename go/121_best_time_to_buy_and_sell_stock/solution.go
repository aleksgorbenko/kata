// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

package main

func maxProfit(prices []int) int {
	if len(prices) == 0 {
		return 0
	}

	// track max profit, start with 0
	maxProfit := 0
	// track minimum price
	minBuyPrice := prices[0]

	// max profit will always be currentPrice - minBuyPrice
	// so if the current price is less than minBuyPrice, then we
	// re-assign minBuyPrice, otherwise we calculate the difference
	for i := 1; i < len(prices); i++ {
		currentPrice := prices[i]

		if currentPrice < minBuyPrice {
			minBuyPrice = currentPrice
		} else {
			maxProfit = max(maxProfit, currentPrice-minBuyPrice)
		}
	}

	return maxProfit
}

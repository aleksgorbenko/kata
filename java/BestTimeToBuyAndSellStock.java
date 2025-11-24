// https://neetcode.io/problems/buy-and-sell-crypto?list=neetcode150

public class Solution {
    public int maxProfit(int[] prices) {
        // 1. init 2 pointers, right is is ahead of left by 1
        int left = 0;
        int right = 1;
        int maxProfit = 0;

        while (right < prices.length) {
            // 2. calculate the profit only the price
            // at the right pointer is higher, we need profit, right?
            if (prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                // 3. we can re-assign left to right because the
                // current right is lower the current left
                left = right;
            }
            // 4. keep checking next price and calculate profit
            right++;
        }
        return maxProfit;
    }
}

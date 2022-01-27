/* You are given an array prices where prices[i] is the price of a given stock on the ith day. You want to maximize your profit by choosing a single day to buy one stock and
choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0. */

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = prices[0];
        int profit = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            profit = Integer.max(profit, prices[i] - buy);
            buy = Integer.min(buy, prices[i]);
        }
        if (profit < 0) return 0;
        return profit;
    }
}

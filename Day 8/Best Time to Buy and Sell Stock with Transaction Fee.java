/* You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again). */

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        
        buy[0] = -(prices[0] + fee);
        sell[0] = 0;
      
        for (int i = 1; i < n; i++) {
            buy[i] = Integer.max(buy[i - 1], sell[i - 1] - (prices[i] + fee));
            sell[i] = Integer.max(sell[i - 1], prices[i] + buy[i - 1]);
        }
        return sell[n - 1];
    }
}

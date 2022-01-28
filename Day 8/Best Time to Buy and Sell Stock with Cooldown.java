/* You are given an array prices where prices[i] is the price of a given stock on the ith day. Find the maximum profit you can achieve. You may complete as many transactions
as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
    After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again). */

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1) return 0;
        int[] noStock = new int[n];
        int[] hold = new int[n];
        int[] sold = new int[n];
        
        noStock[0] = 0;
        hold[0] = -prices[0];
        sold[0] = 0;
        
        for (int i = 1; i < n; i++) {
            noStock[i] = Integer.max(noStock[i - 1], sold[i - 1]);
            hold[i] = Integer.max(hold[i - 1], noStock[i - 1] - prices[i]);
            sold[i] = hold[i] + prices[i];
        }
        return Integer.max(noStock[n - 1], sold[n - 1]);
    }
}

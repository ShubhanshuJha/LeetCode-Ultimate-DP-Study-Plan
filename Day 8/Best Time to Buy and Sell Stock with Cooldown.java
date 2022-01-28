/* You are given an array prices where prices[i] is the price of a given stock on the ith day. Find the maximum profit you can achieve. You may complete as many transactions
as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
    After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again). */

// Using Memoization method
class Solution {
    private int[] memo;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1) return 0;
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return findMax(prices, 0, n);
    }
    private int findMax(int[] prices, int curr, int n) {
        if (curr >= n) return 0;
        if (memo[curr] != -1) return memo[curr];
        
        int maxVal = 0;
        for (int i = curr + 1; i < n; i++)
            if (prices[i] > prices[curr])
                maxVal = Integer.max(maxVal, prices[i] - prices[curr] + findMax(prices, i + 2, n));
        maxVal = Integer.max(maxVal, findMax(prices, curr + 1, n));
        memo[curr] = maxVal;
        return maxVal;
    }
}


// State Machine method
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

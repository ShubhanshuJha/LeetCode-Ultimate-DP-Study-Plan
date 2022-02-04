/* An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
Given an integer n, return the nth ugly number. */

class Solution {
    
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int c2 = 0, c3 = 0, c5 = 0;
        
        for (int i = 1; i < n; i++) {
            int v1 = 2 * dp[c2];
            int v2 = 3 * dp[c3];
            int v3 = 5 * dp[c5];
            
            dp[i] = Integer.min(v1, Integer.min(v2, v3));
            
            if (v1 == dp[i])
                c2++;
            if (v2 == dp[i])
                c3++;
            if (v3 == dp[i])
                c5++;
        }
        return dp[n - 1];
    }
}

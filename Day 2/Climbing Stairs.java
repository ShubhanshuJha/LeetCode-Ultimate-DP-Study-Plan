/* You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? */

class Solution {
//     private HashMap<Integer, Integer> memo = null;
//     public int climbStairs(int n) {
//         memo = new HashMap<>();
//         return dp(n);
//     }
//     private int dp(int i) {
//         if (i <= 2) return i;
//         if (!memo.containsKey(i)) {
//             memo.put(i, dp(i - 1) + dp(i - 2));
//         }
//         return memo.get(i);
//     }
    public int climbStairs(int n) {
        if (n == 1) return 1;
        // An array that represents the answer to the problem for a given state
        int[] dp = new int[n + 1]; 
        dp[1] = 1; // Base cases
        dp[2] = 2; // Base cases
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // Recurrence relation
        }
        return dp[n];
    }
}

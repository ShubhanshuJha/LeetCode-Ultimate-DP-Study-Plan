/* You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
You can either start from the step with index 0, or the step with index 1. Return the minimum cost to reach the top of the floor. */

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 2) return Integer.min(cost[0], cost[1]);
        int[] f = new int[n + 1];
        f[1] = cost[0];
        f[2] = cost[1];
        for (int i = 3; i <= n; i++) {
            f[i] = cost[i - 1] + Integer.min(f[i - 1], f[i - 2]);
        }
        return Integer.min(f[n], f[n - 1]);
    }
}

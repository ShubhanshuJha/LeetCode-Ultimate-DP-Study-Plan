/* Given a triangle array, return the minimum path sum from top to bottom. For each step, you may move to an adjacent number of the row below.
More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row. */

class Solution {
    final int MAX = Integer.MAX_VALUE;
    public int minimumTotal(List<List<Integer>> triangle) {
        // possible moves when standing on (i, j):
        // (i + 1, j) or (i + 1, j + 1)
        int N = triangle.size();
        if (N == 1) return triangle.get(0).get(0);
        
        int[] dp = new int[N + 1];
        
        for (int i = N - 1; i >= 0; i--) {
            int idx = 0;
            for (Integer val : triangle.get(i)) {
                dp[idx] = Integer.min(dp[idx], dp[idx + 1]) + val;
                idx++;
            }
        }
        return dp[0];
    }
}

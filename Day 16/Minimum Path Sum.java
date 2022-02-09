/* Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time. */


class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        
        // Possible moves: down(i + 1, j) or right(i, j + 1)
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = grid[i][j];
                if (i + 1 < m && j + 1 < n)
                    dp[i][j] += Integer.min(dp[i + 1][j], dp[i][j + 1]);
                else if (i + 1 < m)
                    dp[i][j] += dp[i + 1][j];
                else if (j + 1 < n)
                    dp[i][j] += dp[i][j + 1];
            }
        }
        return dp[0][0];
    }
}

/* There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner
(i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 109. */

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // dp[m - 1][n - 1] = 0; // No need to psecify in Java
        // Possible moves: down (i + 1, j) or right (i, j + 1)
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < m && j + 1 < n)
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                else
                    dp[i][j] = 1;
            }
        }
        return dp[0][0];
    }
}

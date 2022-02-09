/* Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area. */


class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dp = new int[m + 1][n + 1];
        int largest = Integer.MIN_VALUE;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // dp[i][j] = min(up, left, upperLeftDiagonal)
                if (matrix[i - 1][j - 1] == '1')
                    dp[i][j] = Integer.min(dp[i - 1][j], Integer.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                else
                    dp[i][j] = 0;
                largest = Integer.max(largest, dp[i][j]);
            }
        }
        return largest * largest;
    }
}

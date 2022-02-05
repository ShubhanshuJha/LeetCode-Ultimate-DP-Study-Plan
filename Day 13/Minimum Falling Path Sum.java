/* Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right.
Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1). */


class Solution {
    final int MAX = Integer.MAX_VALUE;
    int[][] dp = null;
    
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) return matrix[0][0];
        // for each (row, col): possible moves are-
        // [(row + 1, col - 1), (row + 1, col), (row + 1, col + 1)]
        
        dp = new int[n][n];
        for(int i = 0; i < n; i++)
            dp[n - 1][i] = matrix[n - 1][i];
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int l = MAX, m = MAX, r = MAX;
                if (i + 1 < n && j - 1 >= 0)
                    l = matrix[i][j] + dp[i + 1][j - 1];
                if (i + 1 < n)
                    m = matrix[i][j] + dp[i + 1][j];
                if (i + 1 < n && j + 1 < n)
                    r = matrix[i][j] + dp[i + 1][j + 1];
                
                dp[i][j] = Integer.min(l, Integer.min(m, r));
            }
        }
        return Arrays.stream(dp[0]).min().getAsInt();
    }
}

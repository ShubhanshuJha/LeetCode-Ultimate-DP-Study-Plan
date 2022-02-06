/* Given a m x n matrix mat and an integer k, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for:
    i - k <= r <= i + k,
    j - k <= c <= j + k, and
    (r, c) is a valid position in the matrix. */


// Bruteforce approach (Working due to low constraint)
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int s = Integer.max(0, i - k); s <= Integer.min(m - 1, i + k); s++)
                for (int t = Integer.max(0, j - k); t <= Integer.min(n - 1, j + k); t++)
                    ans[i][j] += mat[s][t];
            }
        }
        return ans;
    }
}

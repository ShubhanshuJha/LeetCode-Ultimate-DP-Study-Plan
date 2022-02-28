/* Given a string s, find the longest palindromic subsequence's length in s.
A subsequence is a sequence that can be derived from another sequence by deleting some or no elements
without changing the order of the remaining elements. */

// Recursive approach (Producing TLE)
class Solution {
    static int max(int x, int y) {
        return (x > y) ? x : y;
    }
    public int longestPalindromeSubseq(String s) {
        if (s.length() == 1) return 1;
        return lps(s.toCharArray(), 0, s.length() - 1);
    }
    static int lps(char seq[], int i, int j) {
    // Base Case 1: If there is only 1 character
        if (i == j) {
            return 1;
        }
    // Base Case 2: If there are only 2 characters and both are same
        if (seq[i] == seq[j] && i + 1 == j) {
            return 2;
        }
    // If the first and last characters match
        if (seq[i] == seq[j]) {
            return lps(seq, i + 1, j - 1) + 2;
        }
    // If the first and last characters do not match
        return max(lps(seq, i, j - 1), lps(seq, i + 1, j));
    }
}

// Dynamic Programming approach
class Solution {
    static int max(int x, int y) {
        return (x > y) ? x : y;
    }
    public int longestPalindromeSubseq(String s) {
        if (s.length() == 1) return 1;
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < n - i + 1; j++) {
                int k = i + j - 1;
                if (s.charAt(j) == s.charAt(k) && i == 2)
                    dp[j][k] = 2;
                else if (s.charAt(j) == s.charAt(k))
                    dp[j][k] = dp[j + 1][k - 1] + 2;
                else
                    dp[j][k] = max(dp[j][k - 1], dp[j + 1][k]);
            }
        }
        return dp[0][n - 1];
    }
}

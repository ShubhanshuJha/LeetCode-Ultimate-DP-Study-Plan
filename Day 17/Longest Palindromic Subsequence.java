/* Given a string s, find the longest palindromic subsequence's length in s.
A subsequence is a sequence that can be derived from another sequence by deleting some or no elements
without changing the order of the remaining elements. */

// Producing TLE
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


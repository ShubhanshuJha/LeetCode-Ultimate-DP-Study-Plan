/* Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n. */


class Solution {
    public int numTrees(int n) {
        if (n <= 3) return (int)Math.pow(2, n) - n;
        // Catalan Number formula can be useful in this case
        // Formula: Cn = 2NCn / (N + 1)
        // Cn = ΣCiCn-i-1, where i = 0 to n
        int[] catalan = new int[n + 1];
        catalan[0] = catalan[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++)
                catalan[i] += catalan[j] * catalan[i - j - 1];
        }
        return catalan[n];
    }
}

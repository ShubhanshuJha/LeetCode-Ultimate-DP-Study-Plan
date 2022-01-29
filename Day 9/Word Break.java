/* Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation. */

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        
        for (int i = n - 1; i >= 0; i--) {
            for (String wd : wordDict) {
                int m = wd.length();
                if (i + m <= n && s.substring(i, i + m).equals(wd)) {
                    dp[i] = dp[i + m];
                }
                if (dp[i])
                    break;
            }
        }
        return dp[0];
    }
}

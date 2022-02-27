/* Given a string s, return the longest palindromic substring in s. */

// Bruteforce approach (producing TLE)
class Solution {
    private final boolean isPalin(String s) {
        return s.equals((new StringBuilder(s)).reverse().toString());
    }
    public String longestPalindrome(String s) {
        String res = "";
        StringBuilder subSqnce = null;
        for (int i = 0; i < s.length(); i++) {
            subSqnce = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                subSqnce.append(s.charAt(j));
                if (isPalin(subSqnce.toString()) && subSqnce.length() > res.length())
                    res = subSqnce.toString();
            }
        }
        return res;
    }
}

// Optimized approach
class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int resLen = 0;
        for (int i = 0; i < s.length(); i++) {
            // Odd Length
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if ((r - l + 1) > resLen) {
                    res = s.substring(l, r + 1);
                    resLen = r - l + 1;
                }
                l--; r++;
            }
            // Even Length
            l = i; r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if ((r - l + 1) > resLen) {
                    res = s.substring(l, r + 1);
                    resLen = r - l + 1;
                }
                l--; r++;
            }
        }
        return res;
    }
}

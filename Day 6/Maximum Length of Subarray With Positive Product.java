/* Given an array of integers nums, find the maximum length of a subarray where the product of all its elements is positive. A subarray of an array is a consecutive sequence
of zero or more values taken out of that array. Return the maximum length of a subarray with positive product. */

class Solution {
    public int getMaxLen(int[] nums) {
        int firstNeg = -1, lastZero = -1;
        int negCount = 0, maxLen = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                negCount++;
                if (firstNeg == -1)
                    firstNeg = i;
            }
            if (nums[i] == 0) {
                firstNeg = -1;
                negCount = 0;
                lastZero = i;
            } else {
                if ((negCount & 1) == 0) {
                    maxLen = Integer.max(maxLen, i - lastZero);
                } else {
                    maxLen = Integer.max(maxLen, i - firstNeg);
                }
            }
        }
        return maxLen;
    }
}

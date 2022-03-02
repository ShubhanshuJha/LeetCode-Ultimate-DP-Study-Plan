/* Given an integer array nums, return the length of the longest strictly increasing subsequence.
A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements.
For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]. */

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] LIS = new int[n];
        Arrays.fill(LIS, 1);
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++)
                if (nums[i] < nums[j])
                    LIS[i] = Integer.max(LIS[i], 1 + LIS[j]);
        }
        return Arrays.stream(LIS).max().getAsInt();
    }
}

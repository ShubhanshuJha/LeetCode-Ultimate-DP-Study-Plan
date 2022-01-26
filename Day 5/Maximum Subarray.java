/* Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
A subarray is a contiguous part of an array. */

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        
        for (int i = 0; i < n; i++) {
            currSum += nums[i];
            maxSum = Integer.max(maxSum, currSum);
            if (currSum < 0)
                currSum = 0;
        }
        return maxSum;
    }
}

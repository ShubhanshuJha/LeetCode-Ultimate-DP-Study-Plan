/* An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
    For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.
A subarray is a contiguous subsequence of the array. */

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n <= 2) return 0;
        int[] AP = new int[n];
        AP[0] = 0;
        AP[1] = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2])
                AP[i] = AP[i - 1] + 1;
            else
                AP[i] = 0;
        }
        int totalSlices = Arrays.stream(AP).sum();
        return totalSlices;
    }
}

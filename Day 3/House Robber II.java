/* You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle.
That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two
adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police. */

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        else if (n == 2) return Integer.max(nums[0], nums[1]);
        
        int r1 = nums[0], r2 = Integer.max(nums[0], nums[1]); // from 0 -> n - 1
        int r3 = nums[1], r4 = Integer.max(nums[1], nums[2]); // from 1 -> n  
        
        for (int i = 2; i < n - 1; i++) {
            int t1 = r2;
            int t2 = r4;
            r2 = Integer.max(nums[i] + r1, r2);
            r4 = Integer.max(nums[i + 1] + r3, r4);
            r1 = t1;
            r3 = t2;
        }
        return r2 > r4 ? r2 : r4;
    }
}

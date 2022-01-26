/* You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise. */

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;
        if (nums[0] == 0) return false;

        int jumps = 1;
        int steps = nums[0];
        int maxRange = nums[0];
        for (int i = 1; i < n - 1; i++) {
            maxRange = Integer.max(maxRange, i + nums[i]);
            steps--;
            if (steps == 0) {
                jumps++;
                if (i >= maxRange) {
                    return false;
                }
                steps = maxRange - i;
            }
        }
        return true;
    }
}

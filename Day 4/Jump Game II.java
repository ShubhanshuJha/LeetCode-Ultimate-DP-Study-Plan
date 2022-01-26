/* Given an array of non-negative integers nums, you are initially positioned at the first index of the array. Each element in the array represents your maximum
jump length at that position. Your goal is to reach the last index in the minimum number of jumps. You can assume that you can always reach the last index. */

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        if (nums[0] == 0) return -1;
        
        int jumps = 1;
        int steps = nums[0];
        int maxRange = nums[0];
        for (int i = 1; i < n - 1; i++) {
            maxRange = Integer.max(maxRange, i + nums[i]);
            steps--;
            if (steps == 0) {
                jumps++;
                if (i >= maxRange) {
                    return -1;
                }
                steps = maxRange - i;
            }
        }
        return jumps;
    }
}
